package com.company.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.company.interceptor.SampleInterceptor;

@ComponentScan("com.company.controller")
@EnableWebMvc
@Configuration
public class ServletConfig implements WebMvcConfigurer {
	// <resources mapping="/resources/**" location="/resources/" /> 대체
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	// <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	// <beans:property name="prefix" value="/WEB-INF/views/" />
	// <beans:property name="suffix" value=".jsp" />
    // </beans:bean>
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		registry.viewResolver(viewResolver);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> urlPatterns = Arrays.asList("/doA","/doB","/doC","/");
		registry.addInterceptor(new SampleInterceptor())
			    .addPathPatterns(urlPatterns);
	}
	
	
	
	
	
	
	
	
	
}
