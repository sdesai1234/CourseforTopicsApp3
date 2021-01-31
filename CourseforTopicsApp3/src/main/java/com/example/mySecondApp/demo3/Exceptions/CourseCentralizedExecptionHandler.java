package com.example.mySecondApp.demo3.Exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CourseCentralizedExecptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value= CourseAlreadyExistsException.class)
	public ResponseEntity<Object> handleCourseAlreadyExistsException(CourseAlreadyExistsException e)
	{
		String body1 =" from controller advice ---CourseAlreadyExistsException raised";
		Map<String,String> body2=new LinkedHashMap<String,String>();
		body2.put("timestamp",  LocalDateTime.now().toString());
		body2.put("cause", "This Course already exists");
		//return new ResponseEntity<>(body1,HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(body2,HttpStatus.BAD_REQUEST);
	}
	
}