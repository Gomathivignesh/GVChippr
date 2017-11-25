package com.hc.exception;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;

@Provider
public class ExceptionHttpStatusResolver implements
		ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException exception) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;

		if (exception instanceof BusinessException)
			httpStatus = Response.Status.BAD_REQUEST;

		return Response.status(httpStatus).entity(exception.getMessages())
				.build();
	}

}
