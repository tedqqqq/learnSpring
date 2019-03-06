package com.springmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 *  使用java对象来加载DispatcherServlet和ContextLoaderListener两个应用上下文
 */
public class WebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	//加载contextLoaderListener
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [] {ProjectConfig.class};
	}

	//加载dispatherServlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [] {WebConfig.class};
	}

	
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
