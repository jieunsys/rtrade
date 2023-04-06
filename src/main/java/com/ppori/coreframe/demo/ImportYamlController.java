package com.ppori.coreframe.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportYamlController {
	@Value("${hello.world}")
	String hello1;
	
	@RequestMapping(path="/yaml1", method=RequestMethod.GET)
	public void test1() {
		System.out.println("hello1=" + hello1);
	}
}
