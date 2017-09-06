package com.positivity.servlets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.positivity"})
public class WebConfig extends WebMvcConfigurerAdapter{

	//Spring MVC
	
	//1. InternalResourceViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/static/");
		resolver.setSuffix(".html");
		
		return resolver;
		
		
	}
	
	//2. Configure Default Servlet Handling - Enables Configuration
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		
		configurer.enable();
		
	}
	
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseRegisteredSuffixPatternMatch(true);
        configurer.setUseSuffixPatternMatch(true);
    }
	
	
	
}
