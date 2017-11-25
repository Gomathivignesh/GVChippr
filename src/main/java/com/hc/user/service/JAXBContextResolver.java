package com.hc.user.service;

import com.hc.model.Courses;
import com.hc.model.Response;
import com.hc.model.Status;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;
	private Class[] types = { Response.class, Status.class, Courses.class };

	public JAXBContextResolver() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration.natural().build(),
				types);
	}

	public JAXBContext getContext(Class<?> objectType) {
		return (types[0].equals(objectType)) ? context : null;
	}
}
