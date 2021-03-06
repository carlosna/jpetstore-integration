package org.mybatis.jpetstore.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	
	@Override
	public Response toResponse(Throwable ex) {
		ErrorResponse response = new ErrorResponse(ex.getMessage(), "400");
		
		System.out.println(response);
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(response)
				.type("application/json")
				.build();
	}

}
