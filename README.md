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
 3.thymeleaf引擎中${}是对象表达式，不如用来获取model中key为XX的对象
 而*{}是选择表达式，他是基于某一个选中对象计算的。
 4.过滤器是基于selvet的，拦截器是基于spring的。总体上拦截器更好。
		 //过滤器  拦截器的执行顺序（https://blog.csdn.net/huyiju/article/details/83028720）
		 0：过滤器1的初始化方法
		1：过滤器1，客户端向Servlet发送的请求被我拦截到了
		2：拦截器1的前置方法 preHandle
		3：拦截器2的前置方法 preHandle
		4: controller主方法
		5：拦截器2的后置方法postHandle(在controller主方法执行之后执行)
		6：拦截器1的后置方法postHandle(在controller主方法执行之后执行)
		7：拦截器2的完成后方法afterCompletion(在DispatcherServlet处理完请求后，才会执行)
		8：拦截器1的完成后方法afterCompletion(在DispatcherServlet处理完请求后，才会执行)
		9：过滤器1，Servlet向客户端发送的响应被我拦截到了
		10：过滤器的销毁方法
5.关于spring mvc的配置 可以在java-java ，xml-xml，xml-java（上下文信息:添加org.springframework.web.context.support.AnnotationConfigWebApplicationContext，让spring mvc知道后面是使用java来进行装配应用上下文的）
6.@ExceptionHandler(异常类型)处理异常的方法注解  同一类中使用
	@ControllerAdvice通知声明 所有出现异常的地方均可使用
7.重定向
  使用redirect进行重定向操作 控制器不会解析成视图的名字而是解析成地址.但是此时原来请求中的数据无法传递到新的请求中，
  
 ////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////// 
  Spring的Spring Web Flow的使用
  1.web flow的三大组件 状态 流程 数据
  
 ////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
Spring Security
1.基于java的配置
		继承AbstractSecurityWebApplicationInitializer   继承WebSecurityConfigurerAdapter（实现具体的操作   三个configure）
		数据存储--基于内存的  基于数据库的 基于LDAP--configure(AuthticationManagerBuilder auth)
		拦截请求(请求颗粒度)  configure（HttpSecurity） 拦截的判断是按照顺序进行的 所以将具体的URL放到前面  模糊的URL放到后面。拦截请求还可以设置请求类型是HTTP还是HTTPS。
 
 ////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  //Spring与JDBC
  1.----非检查异常可以不用人为的捕获
  2.Spring的数据访问模板类负责通用的数据访问功能。对于应用程序特定的任务，则会调用自定义的回调对象
  3.首先配置数据库的数据源 ，数据源的创建有：JNDI JDBC 连接池 嵌入式等几种  。创建完数据源以后，通过数据源创建JDBC模板来简化数据库的操作。
  
  
  
  ////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
//Spring 与ORM
1.Spring中Hibernate的使用 首先还是创建DataSource   然后使用利用DataSource创建SessionFactory
2.声明bean new PersistenceExceptionTranslationPostProcessor（）,可以给所有@repository的类加上一个通知器，用来对异常统一进行管理。
