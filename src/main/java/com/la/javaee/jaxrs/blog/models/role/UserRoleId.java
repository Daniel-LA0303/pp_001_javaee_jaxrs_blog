package com.la.javaee.jaxrs.blog.models.role;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {
	
    private static final long serialVersionUID = 121312412354147123L;
    
	private Long idUser;
	
    private Long idRole;

    public UserRoleId() {}

    public UserRoleId(Long idUser, Long idRole) {
        this.idUser = idUser;
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idRole, that.idRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idRole);
    }
}
