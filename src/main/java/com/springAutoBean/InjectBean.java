package com.springAutoBean;

import org.springframework.stereotype.Component;

@Component
public class InjectBean implements InjectBeanInterface{

	public void inject() {
		// TODO Auto-generated method stub
		 System.out.println("这是注入对象的实现类");
	}

}
