package com.ppori.coreframe.demo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name="I18nController 국제화 메시지소스 컨트롤러")
@Controller
@Slf4j
public class I18nController {
	@Autowired
	org.springframework.context.MessageSource messageSource;
	
	@Autowired
	LocaleResolver localeResolver;
	
	// ModelAndView 타입은 @RestController는 스웨거에 보이지 않는다.
	@Operation(summary = "jsp 테스트")
	@RequestMapping(value = "jsptest", method=RequestMethod.GET)
	public String jsptest1(Locale locale, HttpServletRequest request, Model model) {
		log.info("MAV TEST START");
		return("test1"); // VIEWER = /webapp/WEB-INF/mav/test1.jsp
	}
	
	@Operation(summary = "세션로케일 변경하기")
	@RequestMapping(value = "/changeSessionLocale", method=RequestMethod.GET)
	public void changeSessionLocale(String langCode, HttpSession httpSession) {
		log.info("input langCode=" + langCode);
		Locale locale = new Locale(langCode);
		log.info("input locale = " + locale.getLanguage() + "-" + locale.getCountry() );
		httpSession.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(langCode));
	}
	
	@Operation(summary = "세션로케일 적용 스프링 메시지소스 데모")
	@RequestMapping(path="/i18n", method=RequestMethod.GET)
	public String i18n(Locale locale, HttpServletRequest request, Model model) {
		log.info("Locale=" + locale.getLanguage() + ",   itemname = " + messageSource.getMessage("itemname", null, locale));
		SessionLocaleResolver r3 = new SessionLocaleResolver();
		Locale s3 = r3.resolveLocale(request);
		log.info("SessionLocale=" + s3 + ",   itemname = " + messageSource.getMessage("itemname", null, s3));
		
		return null;
	}
}
