## 开启SpringMVC框架配置

## 1、注解的支持
`<`mvc:annotation-driven`/>`

	使用<mvc:annotation-driven>自动加载:
	1、	RequestMappingHandlerMapping处理映射器
	2、	RequestMappingHandlerAdapter处理适配器

	
## 2、开启注解扫描
`<`context:component-scan base-package="..."/>
	
	
## 3  视图解析器对象
 `<`bean id="InternalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 
 `<`property name="prefix" value="/WEB-INF/pages/"/>
 
 `<`property name="suffix" value=".jsp"/>
 
`</`bean>

##@RequestMapping介绍
	1、value和path作用是一样的
	2、method:用于指定请求方式
	3、params:用于指定限制请求参数的条件，它支持简单的表达方式，
		要求参数的key和valeu必须和配置的一模一样。
	4、headers：用于指定限制请求消息头的条件
		注意：
			以上四个属性只要出现2个或以上时，他们的关系是与的关系。

## 请求参数的绑定


