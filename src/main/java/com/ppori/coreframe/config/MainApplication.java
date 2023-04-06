package com.ppori.coreframe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@Slf4j
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ppori"})
@MapperScan(value = {"com.ppori.*"}, annotationClass = Repository.class)
@EnableScheduling // Enable Spring @Schedule
public class MainApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		log.info(">>>>>>>>>> START");
		
		String active1 = System.getProperty("spring.profiles.active");
		if(active1==null || "".equals(active1)) System.setProperty("spring.profiles.active", "local");
		SpringApplication.run(MainApplication.class, args);

		log.info(">>>>>>>>>> START DONE");
		
		/**
		 * application-local.xml: logging.config=classpath:config/logback-${spring.profiles.active}.xml
		 * <layout class="com.ppori.coreframe.config.MaskingPatternLayout">
		 */
		log.info("민감정보 logback 마스킹 테스트");
		log.info("주민번호  801208-1234567  테스트");
		log.info("전화번호 010-0000-0000 테스트");
		log.info("이메일 test12345@naver.com 테스트");
		log.info("여권번호 M12345678 테스트");
		log.info("두번째 여권번호 TJ 0012345 입니다.");
		log.info("운전면허번호 서울12-123456-78 테스트");
		log.info("카드번호  4000-1234-5678-0000 테스트");
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}
	
}
