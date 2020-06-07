package org.mybatis.jpetstore.exceptions;

public class ErrorResponse {
	
	String errorMessage;
	String errorCode;
	
	public ErrorResponse(String errorMessage, String errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
