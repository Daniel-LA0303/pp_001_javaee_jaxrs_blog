package com.la.javaee.jaxrs.blog.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@RequestScoped // dura solo la peticion
@Named
@Stereotype // agrupacion de anotaciones
@Retention(RetentionPolicy.RUNTIME) // se aplica en clases, interfaces etc
@Target(ElementType.TYPE) // disponible en tiempo de ejcucion
public @interface Repsoritory {
}
