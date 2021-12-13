package com.company.confg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/*<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />*/
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
}
