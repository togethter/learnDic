##今日内容
	1、web相关概念回顾：
	2、web服务器软件：Tomcat
	3、Servlet：入门学习
	
##web相关概念回顾：

	1、软件的架构
		1、C/S：客户端/服务器端
		2、B/S：浏览器/服务器端
	2、资源分类
		1、静态资源：所有的用户得到的结果都是一样的，称为静态资源。静态资源可以直接被浏览器解
		析。
			如 html,css,javaScript
		2、动态资源：每个用户访问。动态资源被访问后，需要先转换为静态资源，在返还给浏览器。
	3、网络通信三要素
		1、IP：电子设备(计算机)在网络中的唯一标识 
		2、端口号：应用程序在计算机中的唯一标识，0~65536之间
		3、传输协议：规定了数据传输的规则
			1、基础协议
				1、tcp：安全协议，三次握手。速度稍慢
				2、udp：不安全的广播协议。速度快

##web服务器软件：		
	*服务器：安装了服务器软件的计算机
	*服务器软件：接收用户的请求，处理请求，做出响应
	*web服务器软件：接收用户的请求，处理响应，做出响应
		*在web服务器软件中，可以部署web项目。让用户通过浏览器来访问这些项目
		*web容器
		
	*常见的java相关的web服务器软件：
		*webLogic:oracle公司，大型的javaEE服务器，支持所有的javaEE规范，收费的。
		*webSphere:IBM公司，大型的javaEE服务器，支持所有的javaEE规范，收费的。
		*JBOSS：JBOSS公司，大型的javaEE服务器，支持所有的javaEE规范，收费的。
		*Tomcat：Apache基金组织，中小型的javaEE服务器，仅仅支持少量的javaEE规范servlet/jsp。
			开源的免费的
		
	*javaEE:java语言在企业级开发中使用的技术规范总和，一共规范了13项大的规范
[Tomcat 下载](https://tomcat.apache.org/)	

[mac配置Tomcat](https://blog.csdn.net/lu1024188315/article/details/78677583)

	*Tomcat:web服务器软件
		1、下载
		2、安装：解压压缩包即可
			* 注意：安装的目录不要有中文和空格
		3、卸载：删除目录就可以了
		4、启动
				* windows: bin/startup.bat 双击运行该文件
				* mac: bin/startup.sh 拖到终端
				* 访问：浏览器输入：localhost:8080回车访问 访问自己
				* 					别人的ip:8080访问别人
				* 可能遇到的问题：
					1、黑窗口一闪而过：
						原因：没有正确配置JAVA_HOME环境变量
						解决方案：正确配置JAVA_hOME环境变量
					2、启动报错：
						1、暴力：找到占用的端口号，并且找到对应的进程，杀死该进程
							*netstat -ano：查找被占用的端口号然后去结束对应的进程
						2、温柔：修改自身的端口号
							* confi/server.xml
							* 修改:<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443"/>
							* 一般会将tomcat的默认端口号修改为80。80端口号是http协议默认的端口号
								好处：在访问时不用输入端口号
									 
		5、关闭
			1、正常关闭：
				* 在window：bin/shutdown.bat(双击) mac：bin/shutdown.sh拖到终端后回车
				* ctrl+c
			2、强制关闭：
				*点击启动窗口的x	
		6、配置
			*部署项目的方式
					1、直接将项目放在webapps目录下即可
						* /hello：项目的访问路径--->虚拟目录
						* 简化部署：将项目打成一个war包，在讲war包放置到webapps目录下
								* wer包会自动解压缩					2、配置confi/server.html文件
								* 在<host>标签体中配置
								* <Context docBase="想要存放的资源路径" path="虚拟路径"/> 
										*docBase：项目存放路径
										*path：虚拟目录
								
				 	3、在confi/Catalina/localhost 创建任意名称的xml文件
				 		在文件中编写	<Context docBase="/Users/gd/Desktop/hello" />
				 		*虚拟目录：xml文件的名称
				
			
			*静态项目和动态项目
				*目录结构
					* java动态项目的目录结构
						--项目的根目录
							--WEB-INF目录：
								--web.xml:web项目的核心配置文件
								--classes目录：放置字节码文件的目录
								--lib目录：放置依赖jar包
			*将Tomcat集成到IDEA中，并且创建javaEE的项目，部署项目。
##Servlet
	*概念：运行在服务器端的小程序
		*servlet就是一个接口，定义了java类被浏览器访问到的(tomcat识别)规则
		*将来我们自定义一个类，实现servlet接口，复写方法。
	*快速入门
		1、创建javaEE项目 
		2、定义一个类，实现servlet接口
			public class servletDemo1 implements Servlet
		3、实现接口中的抽象方法
		4、配置servlet
			在web.xml中配置的
			<!--    配置servlet-->
			    <servlet>
			        <servlet-name>demo1</servlet-name>
			        <servlet-class>cn.itcast.web.servlet.servletDemo1</servlet-class>
			    </servlet>
			    <servlet-mapping>
			        <servlet-name>demo1</servlet-name>
			        <url-pattern>/demo1</url-pattern>
			    </servlet-mapping>					 *执行原理
		1、当服务器接收到客户端浏览器的请求后， 会解析请求的URL路径，获取访问的Servlet的资源路径
		2、查找web.xml文件，是否有对应的<url-pattern>标签体内容。
		3、如果有，则找到对应的<servlet-class>全类名
		4、tomcat会将字节码文件加载进内存并且创建其对象
		5、调用其方法
		
		
	*servlet生命周期：
		1、被创建：执行init方法，只执行一次
			* servlet什么时候被创建？
				* 默认情况下，第一次被访问时，servlet被创建
				* 可以配置执行Servlet时创建时机。
					*在<servlet>标签下配置
						1、第一次被访问时创建
	        					* <load-on-startup>的值为负数
	    					2、在服务器启动时，创建
	        					* <load-on-startup>的值为0或正整数
	        	*Servlet的init方法，只执行一次，说明一个servlet在内存中只存在一个对象，servlet是单利的
	        			*多个用户同时访问时，可能存在线程安全问题。
	        			*解决：尽量不要在servlet定义成员变量。即使定义了成员变量，也不要对其赋值，也不要修改值
		2、提供服务：执行servlet方法，执行多次
			*每次访问servlet时，servlet方法都会被调用一次。
		3、销毁：执行destroy方法，只执行一次 
			*servlet被销毁时执行。服务器关闭时，servlet被销毁
			*只有服务器正常关闭时，才会执行destroy方法。
			*destroy方法在servlet被销毁之前执行，一般用于释放资源
			
	*servlet3.0：
		*好处：
			*支持注解配置。可以不需要web.xml了。
		*步骤：
			*创建javaEE项目，选择servlet版本3.0以上，可以不创建web.xml
			*定义一个类，实现servlet接口
			*复写方法
			*在类上使用@webServlet注解，进行配置
				*Webservlet("资源路径")	
			    
## IDEA与Tomcat的相关配置
	1、IDEA会为每一个tomcat部署的项目单独建立一份配置文件
		*查看控制台的输出 CATALINA_BASE: /Users/gd/Library/Caches/JetBrains/IntelliJIdea2020.1/tomcat/
		Tomcat_8_5_57_day_tomcat_2			    
			 
	2、工作空间项目		和		tomcat部署的web项目
		*tomcat真正访问的是"tomcat部署的web项目"tomcat部署的web项目对应着"工作空间项目"的web目录下的所有资源
		*WEB-INF目录下的资源不能直接被浏览器直接访问
	3、断点调试：使用"小虫子"启动debug启动			 
					
				
		
		
		
		
		
		
		
		
		
		
		
		