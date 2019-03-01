package com.springjavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//java的显示装配
@Configuration
public class JavaConfig {

	//@Bean   创建对象存放到applicationContext中进行存放
	//bean后面一个跟一个name=“” 用作beanid  默认情况下是createMan
	//bean的单例问题 遇见相同类型的bean不会重复创建 
	//此处的Person会根据其他位置的Bean（不一定是用一个文件里面的Bean）进行自动装配
	@Bean
	public Man createMan(Person person) {
			return new Man(person);		
	}
	
	@Bean
	public Person createPerson() {
		return new Person();
	}
}
