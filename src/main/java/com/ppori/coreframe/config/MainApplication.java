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
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}
	
}
