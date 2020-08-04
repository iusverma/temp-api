package com.ayush.temp.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ayush.temp.objects.Generic;
import com.ayush.temp.objects.GenericData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Component
public class YamlParser {

	public List<Generic> getData(final String genericCode) {
		List<Generic> ret = new ArrayList<Generic>();
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.findAndRegisterModules();
		try {
			String genericFile = "src/main/resources/application-"+genericCode+".yaml";
			System.out.println("Generics file: "+genericFile);
			GenericData generics = mapper.readValue(
					new File(genericFile),
					GenericData.class);
			if(!CollectionUtils.isEmpty(generics.getGeneric())) {
				if(generics.getGeneric()!=null) {
					for(Generic gen:generics.getGeneric()) {
						System.out.println(gen.getCode());
						System.out.println(gen.getName());
						ret.add(gen);
					}
				}
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
