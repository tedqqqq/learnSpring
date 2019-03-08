//package com.springmvc;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletRegistration.Dynamic;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///*
// *  使用java对象来加载DispatcherServlet和ContextLoaderListener两个应用上下文
// */						
//public class WebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{
//
//	//加载contextLoaderListener
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class<?> [] {ProjectConfig.class};
//	}
//
//	//加载dispatherServlet
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class<?> [] {WebConfig.class};
//	}
//
//	
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] {"/"};
//	}
//
//// 	//对spring mvc的细化定制
////	  @Override
////	  protected void customizeRegistration(Dynamic registration) {
////	    registration.setMultipartConfig(
////	        new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0));
////	  }
//}
