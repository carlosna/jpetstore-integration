package org.mybatis.jpetstore.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class QueryParamInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QueryParamInvalidException(String message) {
		super(message);		
	}	
}
