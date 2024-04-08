package com.mycompany.web;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/** 
 * Configuration class for setting up web-related configurations in the application.
 * This class was mainly written to manage the i18n in the program and for adding view controllers.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/** 
	 * Bean to provide the LocaleResolver.
	 * Sets the default language to English (EN).
	 * @return SessionLocaleResolver
	 */
	@Bean
	LocaleResolver localeResolver() {
		
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.of("en"));
		return slr;
		
	}
	
	/** 
	 * Bean to provide the LocaleChangeInterceptor.
	 * Sets the parameter name for locale change to "lang".
	 * @return LocaleChangeInterceptor
	 */
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
		
	}
	
	/**
	 * @param registry InterceptorRegistry to add interceptors
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	/** 
	 * @param registry ViewControllerRegistry to add view controllers
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login");
		registry.addViewController("/errors/403").setViewName("/errors/403");
		
	}

}
