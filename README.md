# learnSpring
1.并发
在Object提供的消息通知机制应该遵循如下这些条件：

1.永远在while循环中对条件进行判断而不是if语句中进行wait条件的判断；
2.使用NotifyAll而不是使用notify。:

2.spring框架  注意Spring的版本的问题

DI是应用对象之间的解耦  AOP是横切关注点与它们所影响的对象之间的解耦

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
 (6)处理自动装配的歧义性
  使用@primary或者primary=true来让此bean或者component作为首选项
  使用@Quaifier自定义注解类（自定义Quaifier和使用Quaifier("XXX")）
  (7)bean的作用域
    使用的注解@Scope  
    一共有四种类型 Singleton（默认） Prototype  Session(Web) Request(Web)
    proxyMode代理模式（类 接口）
   (8)外部注入信息
     使用外部注入方式（${}）  使用SPEL表达式（#{}）
    (9)面向切面编程（代理实现@EnableAspectJAutoProxy）
    
   Aop的基本概念 ：
    
   通知（定义类去干什么 什么时候去干  五大通知类型）  
    连接点（虚拟，程序执行过程中引入通知的点   程序执行开始、程序抛出异常、程序执行结束...）
    切点（符合切面执行的位置，一个切点里面可以包括很多个连接点）   
    切面（包括了切点和通知）  ---通过代理来实现
    引入（Introduction）：引介是一种特殊的增强，它为类添加一些属性和方法。这样，即使一个业务类原本没有实现某个接口，通过引介功能，可以动态的未该业务类添加接口的实现逻辑，让业务类成为这个接口的实现类。
	织入（Weaving）：织入是将增强添加到目标类具体连接点上的过程，AOP有三种织入方式：①编译期织入：需要特殊的Java编译期（例如AspectJ的ajc）；②装载期织入：要求使用特殊的类加载器，在装载类的时候对类进行增强；③运行时织入：在运行时为目标类生成代理实现增强。Spring采用了动态代理的方式实现了运行时织入，而AspectJ采用了编译期织入和装载期织入的方式。 
	
spring aop的特点：
	1.spring只支持方法级别的连接点
	2.spring是在运行时通知对象的
    3.spring中通知的执行顺序：https://blog.csdn.net/qq_32331073/article/details/80596084
    4.通过代理是实现aop的功能
spring中的环绕通知 通过ProceedingJoinPoint的proceed将执行的控制权交给被通知的方法  还可以使用args（XXX）来获取方法中的变量值
     
////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
Spring web的运用 Spring MVC
1.在Spring mvc中实际上是有两个应用上下文
 		AbstractAnnotationConfigDispatcherServlet-Initializer
 第一个是：DispatcherServlet（用来加载web相关的bean 比如说：视图解析器、处理器映射和控制器等）
 第二个是：ContextLoaderListener：用来加载应用中其他的bean
 2,在Spring的类中注入接口，那么spring框架会在实例化中自动装配接口的实现类