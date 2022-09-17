package com.example.demo.exception;


public class IncorrectLoginCredentialsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IncorrectLoginCredentialsException()
	{}
	
	public IncorrectLoginCredentialsException(String msg)
	{
		super(msg);
	}

}