package com.springAutoBean;

import org.springframework.stereotype.Component;

@Component
public class AutoWireBean  {
	
	private int  id;
	
	public void testAuto() {
		System.out.println("这是一个自动装配的对象");
	}

}
