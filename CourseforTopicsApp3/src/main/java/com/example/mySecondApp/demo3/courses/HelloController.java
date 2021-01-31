package com.example.mySecondApp.demo3.courses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> sayHi() {
		
	// return "Hello";
	 
	 
	 return  ResponseEntity.status(200).header("my_custom-header", "no values").body("Hello Hi");
	}
	
	@GetMapping("/snehal")
	public String snehalPage(@RequestParam(value="id") Long id, @RequestParam(value="name") String name)
	{
	   	
         return "id=" + id + "  name =" +name;
		
	}
}
