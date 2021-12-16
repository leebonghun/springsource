package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
@ComponentScan("com.company.controller")
@EnableWebMvc
@Configuration
public class ServletConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
	@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
			internalResourceViewResolver.setViewClass(JstlView.class);
			internalResourceViewResolver.setPrefix("/WEB-INF/views/");
			internalResourceViewResolver.setSuffix(".jsp");
			
			registry.viewResolver(internalResourceViewResolver);
			
		}
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver= new CommonsMultipartResolver();
		return resolver;
	}
}
