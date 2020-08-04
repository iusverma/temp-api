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
import com.ayush.temp.objects.Response;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Value("${generics}")
	String [] generics;

	@Resource
	private YamlParser yamlParser;

	@RequestMapping(value="/generics", method=RequestMethod.GET)
	@ResponseBody
	public Response fetchGenerics(
			@RequestBody String body,
			HttpServletRequest request){
		Response re = null;
		List<Generic> ret = new ArrayList<>();
		System.out.println("Reached Controller.");
		System.out.println("Request"+body);
		System.out.println("Generics loaded: " + generics.length);

		if(body.contains("{}")
				||body.contains("[{}]")
			    ||body.contains("[]")
				||body.length()<10){
			// No request load all data
			for(int i=0;i<generics.length;i++) {
				ret.addAll(yamlParser.getData(generics[i]));
			}
		}else {
			// Selective code fetch
			for(int i=0;i<generics.length;i++) {
				if(body.contains(generics[i])) {
					ret.addAll(yamlParser.getData(generics[i]));
				}
			}
		}
		if(!CollectionUtils.isEmpty(ret)) {
			re = new Response();
			List<Generic> generics = new ArrayList<>();
			for(Generic gen: ret) {
				System.out.println("Code: "+gen.getCode() +", Name: "+gen.getName());
			}
			generics.addAll(ret);
			re.setGenerics(generics);
		}
		return re;
	}
}
