package com.ayush.temp.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.temp.api.utils.YamlParser;
import com.ayush.temp.objects.Generic;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Value("${generics}")
	String [] generics;

	@Resource
	private YamlParser yamlParser;

	@RequestMapping(value="/generics", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> fetchGenerics(
			@RequestBody String body,
			HttpServletRequest request){
		ResponseEntity<String> re = null;
		List<Generic> ret = new ArrayList<>();
		System.out.println("Reached Controller.");
		System.out.println("Request"+body);
		System.out.println("Generics loaded: " + generics.length);

		for(int i=0;i<generics.length;i++) {
			ret.addAll(yamlParser.getData(generics[i]));
		}
		if(!CollectionUtils.isEmpty(ret)) {
			for(Generic gen: ret) {
				System.out.println("Code: "+gen.getCode() +", Name: "+gen.getName());
			}
		}
		return re;
	}
}
