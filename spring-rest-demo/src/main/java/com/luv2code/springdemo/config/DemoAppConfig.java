package com.luv2code.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springdemo")
public class DemoAppConfig {

	
	/* incase of spring mvc we have to redirect ot views so when
	 using the mvc thrugh java configuration will be using view resolver like 
	 this along with other configurations 
	 
	@Bean
	public ViewResolver viewResover() {
		
		InternalResourceViewResolver viewResolver =
				new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	
	} */
	
}
