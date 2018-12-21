package com.cbp.disponibilite.gestionnaires.services.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

@ApplicationPath("/")
public class JerseyApplication extends ResourceConfig {
	/**
	 * Register JAX-RS application components.
	 *
	 *
	 *
	 */

	public JerseyApplication(@Context ServletContext servletContext) {
		// Spring
		packages("com.cbp.disponibilite.gestionnaires.services.resources");
	}

}