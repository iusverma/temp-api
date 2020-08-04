package com.ayush.temp.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Value("${generics}")
	String [] generics;
	
	@RequestMapping(value="/generics", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> fetchGenerics(
			@RequestBody String body,
			HttpServletRequest request){
		ResponseEntity<String> re = null;
		System.out.println("Reached Controller.");
		System.out.println("Request"+body);
		System.out.println("Generics loaded: " + generics.length);

		return re;
	}
}
