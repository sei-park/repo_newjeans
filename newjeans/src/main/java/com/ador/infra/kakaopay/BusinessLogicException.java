package com.ador.infra.kakaopay;

public class BusinessLogicException extends RuntimeException {
	
	private final ExceptionCode exceptionCode;

	public BusinessLogicException(ExceptionCode exceptionCode) {
		
		super(exceptionCode.getMessage());
	    this.exceptionCode = exceptionCode;
	}

	public ExceptionCode getExceptionCode() {
		
	    return exceptionCode;
	    
	 }

}
