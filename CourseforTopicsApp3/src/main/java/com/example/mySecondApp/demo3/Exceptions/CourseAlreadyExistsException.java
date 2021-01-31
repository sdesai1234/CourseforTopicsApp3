package com.example.mySecondApp.demo3.Exceptions;

public class CourseAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseAlreadyExistsException(String str)
	{
		
		super(str);
	}
}
