package com.ppori.coreframe.demo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "ThymeleafController 타임리프 컨트롤러")
@Slf4j
@Controller
public class ThymeleafController {
	@Operation(summary = "view-thyme 테스트")
	@RequestMapping(value="/view-thyme1", method=RequestMethod.GET)
	public String responseViewV2(Model model) {
		model.addAttribute("data1", "This is hello!!");

		return "thyme/hello1"; // resources/templates/thyme/hello1.html 매핑
	}
	
	@Operation(summary = "view-jsp 테스트")
	@RequestMapping(value = "/view-jsp1", method=RequestMethod.GET)
	public String jsptest1(Locale locale, HttpServletRequest request, Model model) {
		log.info("MAV TEST START");
		return("test1"); // webapp/WEB-INF/mav/test1.jsp 매핑
	}
	
}
