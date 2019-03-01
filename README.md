# learnSpring
1.并发
在Object提供的消息通知机制应该遵循如下这些条件：

1.永远在while循环中对条件进行判断而不是if语句中进行wait条件的判断；
2.使用NotifyAll而不是使用notify。:

2.spring框架  注意Spring的版本的问题
（1）Bean的生命周期  大致11步骤
 实例化-填充属性-setBeanName-setBeanFactory-setApplicationContext-
 -BeanPostProcessor的before方法-initializingBean的afterPropeties方法-
 -自定义初始化方法-BeanPostProcessor的after方法-distroy bean方法。
 （2）Spring中转配Bean的三种方式
 使用自动装配的方式    在java中显示装配（javaConfig）      使用XML     
 (3)Spring中bean的单例性
 (4)对象的生产 注意使用@ContextConfiguration  有位置确认(XML)和class确认两种
 (5)Spring中不同环境的开发
   定义：使用@profile对bean的创建环境进行定义   
   使用（设置spring.profiles.active和spring.profiles.default参数对环境进行设置）：
   作为DispatcherServlet的初始化参数；
	作为Web应用的上下文参数；
	作为JNDI条目；
	作为环境变量；
	作为JVM的系统属性；
	在集成测试类上，使用@ActiveProfiles注解设置
 
