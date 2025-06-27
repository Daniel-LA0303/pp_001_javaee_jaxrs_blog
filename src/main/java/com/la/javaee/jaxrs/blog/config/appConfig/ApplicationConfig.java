package com.la.javaee.jaxrs.blog.config.appConfig;

import java.util.Collections;
import java.util.Set;

import com.la.javaee.jaxrs.blog.web.HelloController;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return Collections.singleton(HelloController.class);
	}

}