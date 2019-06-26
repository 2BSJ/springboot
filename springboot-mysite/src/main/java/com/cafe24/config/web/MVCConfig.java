package com.cafe24.config.web;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

//@Configuration
//@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

	//
	// View Resolver
	//
	
	@Bean 
	public ViewResolver viewResolver() { // 뷰 리졸버 설정
	 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 resolver.setPrefix("/WEB-INF/views/");
	 resolver.setSuffix(".jsp");
	 resolver.setExposeContextBeansAsAttributes(true);
	 
	 return resolver;
	 }


	
	//
	// Default Servlet Handler
	//
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}


	//
	//	Message Converter
	//
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd")).modulesToInstall(new ParameterNamesModule());
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", Charset.forName("utf-8")))); 		//"application/json; charset=utf-8"
		
		
		return converter;
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "html", Charset.forName("utf-8")))); 		//"application/json; charset=utf-8"
		return converter;
		
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			converters.add(mappingJackson2HttpMessageConverter()); //두개가 이써서 빈에서 생성하고 밑에도 만들어지는거 아니냐? 이게아니라 위에서 컨테이너에 빈이 생성되고 그 빈이 주입됨
			converters.add(stringHttpMessageConverter());
	}
	
	
	
	
	
	
}
