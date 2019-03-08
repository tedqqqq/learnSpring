package com.springmvc;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//开启spring mvc功能
@EnableWebMvc
//自动扫描 用来加载控制器
@ComponentScan("com.springMvcController")
public class WebConfig  extends WebMvcConfigurerAdapter{

	//视图解析器
	  @Bean
	  public ViewResolver viewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    
	    return resolver;
	  }
	
	
	//对静态资源放行
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	//文件上传
	  @Bean
	  public MultipartResolver multipartResolver() throws IOException {
	    return new StandardServletMultipartResolver();
	  }
}
