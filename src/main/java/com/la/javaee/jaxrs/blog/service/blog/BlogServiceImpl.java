package com.la.javaee.jaxrs.blog.service.blog;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.la.javaee.jaxrs.blog.exceptions.AppException;
import com.la.javaee.jaxrs.blog.models.blog.BlogEntity;
import com.la.javaee.jaxrs.blog.models.category.CategoryEntity;
import com.la.javaee.jaxrs.blog.repository.blog.BlogRepository;
import com.la.javaee.jaxrs.blog.service.category.CategoryService;
import com.la.javaee.jaxrs.blog.service.user.UserService;
import com.la.javaee.jaxrs.blog.utils.dto.blog.BlogDTO;
import com.la.javaee.jaxrs.blog.utils.enums.MethodEnum;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BlogServiceImpl implements BlogService {

	@Inject
	private BlogRepository blogRepository;

	@Inject
	private UserService userService;

	@Inject
	private CategoryService categoryService;

	@Override
	public BlogEntity createBlog(BlogDTO blogDTO) {

		// 1. buscamos user, si no esta ya se maneja la exception internamente en el
		// servicio
		userService.getOneUser(blogDTO.getUserId());

		// 2. coroboramos existencia de las categorias
		List<CategoryEntity> categories = categoryService.validateCategories(blogDTO.getCategories());

		// 3. bucamos algun blog con el mismo, si existe retronamos exception de que ya
		Optional<BlogEntity> blogExists = blogRepository.getByTitle(blogDTO.getTitle());

		if (blogExists.isPresent()) {
			throw new AppException("Blog already exists with title: " + blogDTO.getTitle(),
					Response.Status.BAD_REQUEST.getStatusCode(), "/api/blogs", MethodEnum.POST);
		}

		// 4. Generar slug único
		String baseSlug = generateSlug(blogDTO.getTitle());
		String uniqueSlug = ensureUniqueSlug(baseSlug);

		// 5. Calcular tiempo estimado de lectura
		int wordCount = countWords(blogDTO.getContent());
		Integer minRead = Math.max(1, wordCount / 200);

		// 6. llenamos los datos restantes de la entidad que son campos default
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setBlogImgURL("http://example.com");
		blogEntity.setCategories(new HashSet<>(categories));
		blogEntity.setContent(blogDTO.getContent());
		blogEntity.setCreatedAt(LocalDateTime.now());
		blogEntity.setDescription(blogDTO.getDescription());
		blogEntity.setIdUser(blogDTO.getUserId());
		blogEntity.setMinRead(Integer.toString(minRead));
		blogEntity.setStatus("ACTIVE");
		blogEntity.setTitle(blogDTO.getTitle());
		blogEntity.setUpdatedAt(LocalDateTime.now());
		blogEntity.setSlug(uniqueSlug);

		return blogRepository.createBlog(blogEntity);
	}

	@Override
	public List<BlogEntity> getAll() {
		return blogRepository.getAll();
	}

	@Override
	public BlogEntity getOneBlog(Long idBlog) {
		return blogRepository.getBlogById(idBlog).orElseThrow(() -> new AppException("Blog not found: " + idBlog,
				Response.Status.NOT_FOUND.getStatusCode(), "/api/blogs", MethodEnum.GET));
	}

	@Override
	public BlogEntity updateBlog(Long idBlog, BlogDTO blogDTO) {
		// 1. Obtener el blog existente (lanza excepción si no existe)
		BlogEntity existingBlog = getOneBlog(idBlog);

		// 2. Verificar que el userId no haya cambiado
		if (!existingBlog.getIdUser().equals(blogDTO.getUserId())) {
			throw new AppException("User ID mismatch: blog does not belong to user " + blogDTO.getUserId(),
					Response.Status.FORBIDDEN.getStatusCode(), "/api/blogs/" + idBlog, MethodEnum.PUT);
		}

		// 3. Verificar unicidad del título (evitar que lo compare con sí mismo)
		blogRepository.getByTitle(blogDTO.getTitle()).ifPresent(duplicate -> {
			if (!duplicate.getIdBlog().equals(idBlog)) {
				throw new AppException("Blog title already exists: " + blogDTO.getTitle(),
						Response.Status.CONFLICT.getStatusCode(), "/api/blogs/" + idBlog, MethodEnum.PUT);
			}
		});

		// 4. Validar existencia de las categorías
		List<CategoryEntity> categories = categoryService.validateCategories(blogDTO.getCategories());

		// 5. Recalcular minRead
		int wordCount = countWords(blogDTO.getContent());
		Integer minRead = Math.max(1, wordCount / 200);

		// 6. Actualizar los datos en la entidad
		existingBlog.setTitle(blogDTO.getTitle());
		existingBlog.setDescription(blogDTO.getDescription());
		existingBlog.setContent(blogDTO.getContent());
		existingBlog.setCategories(new HashSet<>(categories));
		existingBlog.setMinRead(minRead.toString());
		existingBlog.setUpdatedAt(LocalDateTime.now());

		// Slug se mantiene igual

		return blogRepository.updateBlog(idBlog, existingBlog);
	}

	private int countWords(String content) {
		if (content == null || content.trim().isEmpty()) {
			return 0;
		}
		return content.trim().split("\\s+").length;
	}

	private String ensureUniqueSlug(String baseSlug) {
		String slug = baseSlug;
		int suffix = 1;

		// se asegura de lo poco probable de ue se repita un slug
		while (blogRepository.existsBySlug(slug)) {
			slug = baseSlug + "-" + suffix++;
			if (suffix > 50) {
				throw new AppException("Unable to generate a unique slug for: " + baseSlug,
						Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "/api/blogs", MethodEnum.POST);
			}
		}

		return slug;
	}

	private String generateSlug(String title) {
		String normalized = Normalizer.normalize(title, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
				.toLowerCase().replaceAll("[^a-z0-9\\s]", "").replaceAll("\\s+", "-").replaceAll("-+", "-");

		return normalized;
	}

}
