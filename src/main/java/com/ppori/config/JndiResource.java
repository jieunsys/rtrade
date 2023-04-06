package com.ppori.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class JndiResource {
	@Value("${spring.datasource.jndi-name}")
	private String jndiName;
	
	@Value("${rtrade.jndi.driver.class.name}")
	private String driverClassName;
	
	@Value("${rtrade.jndi.url}")
	private String url;
	
	@Value("${rtrade.jndi.username}")
	private String username;
	
	@Value("${rtrade.jndi.password}")
	private String password;
	
	@Bean
	public void init() {
		log.info("################### start jndiResource()");
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				context.getNamingResources().addResource(getResource());
			}
		};
	}
	
	public ContextResource getResource() {
		ContextResource resource = new ContextResource();
		resource.setName("jndi_RTRADE");
		resource.setType("javax.sql.DataSource");
		resource.setAuth("Container");
		resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
		
		resource.setProperty("driverClassName", driverClassName);
		resource.setProperty("url", url);
		resource.setProperty("username", username);
		resource.setProperty("password", password);
		
		log.info("########## url = " + url);
		return resource;
	}
	
}
