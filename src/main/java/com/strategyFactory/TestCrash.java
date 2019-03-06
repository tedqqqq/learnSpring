package com.strategyFactory;

import org.junit.Test;

public class TestCrash {
	
	@Test
	public void test(){
		Strategy strategy=new Strategy(new ApplePay());
		System.out.println(strategy.getMoney("applePay"));
	}

}
