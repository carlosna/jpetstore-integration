package org.mybatis.jpetstore.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.mybatis.jpetstore.exceptions.ErrorResponse;
import org.mybatis.jpetstore.exceptions.GenericExceptionMapper;
import org.mybatis.jpetstore.exceptions.QueryParamInvalidException;

@ApplicationPath("/rest")
public class JpetstoreRestApplication extends Application {
	
	public JpetstoreRestApplication() {
		
	}
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(ProductEndpoint.class);
		resources.add(GenericExceptionMapper.class);
		resources.add(QueryParamInvalidException.class);
		resources.add(ErrorResponse.class);
		return resources;
	}
 
}
