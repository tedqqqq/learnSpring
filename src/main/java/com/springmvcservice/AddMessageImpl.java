package com.springmvcservice;

import org.springframework.stereotype.Component;

@Component
public class AddMessageImpl  implements AddMessage{

	@Override
	public String addAddress() {
		// TODO Auto-generated method stub
		return "测试一下Spring接口的装配 一般使用接口来进行解耦合";
	}

}
