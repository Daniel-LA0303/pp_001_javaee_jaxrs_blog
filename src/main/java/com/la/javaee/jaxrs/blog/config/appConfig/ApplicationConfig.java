package com.la.javaee.jaxrs.blog.config.appConfig;

import java.util.HashSet;
import java.util.Set;

import com.la.javaee.jaxrs.blog.web.HelloController;
import com.la.javaee.jaxrs.blog.web.blog.BlogResource;
import com.la.javaee.jaxrs.blog.web.category.CategoryResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		resources.add(HelloController.class);
		resources.add(CategoryResource.class); // <-- Aquí agregas tu otra clase
		// Puedes seguir agregando más recursos

		resources.add(BlogResource.class);
		return resources;
	}

}
