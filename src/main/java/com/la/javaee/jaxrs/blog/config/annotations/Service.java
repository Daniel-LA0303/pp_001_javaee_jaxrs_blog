package com.la.javaee.jaxrs.blog.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Stereotype // agrupacion de anotaciones
@Named
@ApplicationScoped // dura toda la aplicacion
@Target(ElementType.TYPE) // aplicacion en classes, interfaces, enums etc
@Retention(RetentionPolicy.RUNTIME) // disponible en tiempo de ejecucion
public @interface Service {

}
