package com.ayush.temp.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@RequestMapping(value="/generics", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> fetchGenerics(){
		ResponseEntity<String> re = null;
		System.out.println("Reached Controller.");
		return re;
	}
}
