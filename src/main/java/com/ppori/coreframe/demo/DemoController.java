package com.ppori.coreframe.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="DemoController DEMO 컨트롤러")
@RestController
public class DemoController {
	
	@Operation(summary = "demo 메소드")
	@RequestMapping(path="/demo1", method=RequestMethod.GET)
	public String demo1() {
		new ImportYamlController().test1();
//		return "Hello1";
		return "{\"key\":123}";
	}
	
	
//	@Operation(summary = "demo 3초 딜레이2")
//	@RequestMapping(path="/sec3", method=RequestMethod.GET)
//	public Callable<String>  sec3() {
//		return() -> {
//			Thread.sleep(3000);
//			return "OK sec3 200";
//		};
//	}
	
}
