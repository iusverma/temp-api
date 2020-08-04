package com.ayush.temp.api.utils;

import org.junit.Test;

public class YamlParserTest {
	@Test
	public void test() {
		YamlParser yamlParser = new YamlParser();
		yamlParser.getData("COUNTRYCODE");
		yamlParser.getData("LANGUAGE");
	}

}