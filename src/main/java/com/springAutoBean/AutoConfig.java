package com.springAutoBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//这里可以是包名 也可以是类名（）
@ComponentScan({"com.springAutoBean"})
//componentScan是自动扫描  configuration是配置类的说明
public class AutoConfig {
	
}
