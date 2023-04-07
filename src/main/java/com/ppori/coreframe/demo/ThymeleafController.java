package com.ppori.coreframe.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppori.rtrade.domain.Apt;

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
		List<Apt> aptList = new ArrayList<Apt>();
		Apt apt = new Apt();
		apt.setStreetAdd("Hello1");
		apt.setAptComplex("단지1");
		apt.setPrice(BigInteger.valueOf(1000));
		aptList.add(apt);
		
		Apt apt2 = new Apt();
		apt2.setStreetAdd("Hello2");
		apt2.setAptComplex("단지2");
		apt2.setPrice(BigInteger.valueOf(15000));
		aptList.add(apt2);
		
		log.info("##################" + aptList);
		
		model.addAttribute("aptList", aptList);

		return "thyme/aptlist";
	}
	
	@Operation(summary = "view-jsp 테스트")
	@RequestMapping(value = "/view-jsp1", method=RequestMethod.GET)
	public String jsptest1(Locale locale, HttpServletRequest request, Model model) {
		log.info("MAV TEST START");
		return("test1"); // webapp/WEB-INF/mav/test1.jsp 매핑
	}
	
}
