package labMVC;

import java.util.Properties;

//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
		// Handles HTTP GET requests for /resources/** by efficiently serving up static 
		// resources in the ${webappRoot}/resources/ directory
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}
		  
		// Java configuration equivalent to 
		// <mvc:default-servlet-handler/> in spring-servlet.xml
		// used to use bootstrap when security is enabled
		@Override
	    public void configureDefaultServletHandling(
	            DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
		
		//Resolves views selected for rendering by @Controllers to .jsp resources in the 
		// /WEB-INF/views directory
		@Bean
		public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = 
	                        new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			viewResolver.setOrder(2);
			return viewResolver;
		}
		
		@Bean
	    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
	    {
	        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
	        Properties mappings = new Properties();
	        mappings.put("labMVC.controller.SpringException", "security/ExceptionPage");//adjust error handling
	        mappings.put("defaultErrorView", "security/error");//adjust error handling
	        b.setExceptionMappings(mappings);
	        return b;
	    }	
}
