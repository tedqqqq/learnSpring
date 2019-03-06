package com.strategyFactory;

/**
 * 策略工厂类
 * @author invengo
 *
 */
public class Strategy {
	
	private Crash crash;

	public Strategy(Crash crash) {
		
		this.crash = crash;
	}

	//根据parm类型的不同 执行不同的算法
	public  String getMoney(String parm) {
		String returnMessage = null;
		switch  (parm){
		case "applePay" :
			returnMessage= crash.getMoney("不支持深圳地铁和公交");
			break;		
		}
		return returnMessage;
	}
}
