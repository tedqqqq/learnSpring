package com.springAutoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoWireBean  {

	
	public void testAuto() {
		System.out.println("这是一个自动装配的对象");
	}

	// 自动注入对象
	@Autowired(required=false)
	public String testInject(InjectBeanInterface  injectBean) {
		injectBean.inject();
		return "自动装配Bean的注入方法测试";
		
	}
}
