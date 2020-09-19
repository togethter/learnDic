Maven下载链接：[http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi)

Maven管理的jar:[https://mvnrepository.com/](https://mvnrepository.com/)

maven下载文件释义：

1.Binary tar.gz archive：是装在Linux、MacOsX上的。

2.Binary zip archive：是装在windows上的。

安装步骤
1、在终端输入  vim ~/.bash_profile

2、进入后，按下Edit键，在按i进入insert模式；

3、环境变量如下：
#	路径是刚才下载解压后的路径
 export MAVEN_HOME=/Users/Destiny/JavaTool/apache-maven-3.5.4

 export PATH=$PATH:$MAVEN_HOME/bin

4、按下 ESC，退出insert模式

5、输入:wq (保存修改)退出当前文件

6、使修改的环境变量bash_profile文件生效，输入 source .bash_profile，按下Enter键即可

7、mvn -v 查看是否成功


# 本地存储配置
	1、如果您不配置，默认会在如下位置存放从远程下载到的包：
	2、从中央仓库下载的jar包，都会统一存放到本地仓库，我们需要配置本地仓库的位置。
		打开maven安装目录，打开conf目录下的seting.xml文件。
		通过配置该标签
			<localRepository>..存放路径..</localRepository>
	3、可以在运行时指定本地仓库位置：
		mvn  clean  install -Dmaven.repo.local=d:\yourpath
#	中央仓库配置
	当构建一个Maven项目，首先检查pom.xml文件以确定依赖包的下载位置，执行顺序如下：
		1、从本地资源库中查找并获得依赖包，如果没有，执行第二步。
		2、从Maven默认中央仓库中查找并获得依赖包(http://repo1.maven.org/maven2/),如果没有，
			执行第三步。
		3、如果在pom.xml中定义了自定义的远程仓库，那么也会在这里的仓库中进行查找并获得依赖包，
		如果都没有找到，那么maven就会抛出异常
		
#	修改镜像
		<mirrors>
			<mirror>
			<id> nexus-aliyun</id>
			<mirrorOf>.....
			
			</mirror>
		</mirrors>	

# 命令行创建maven项目
	方法一：
		1、选择具体的要存放的目录
		2、输入命令 mvn archetype:generate,回车，根据提示输入参数，如果是第一次使用，需要下载插件(指定骨架)
		
	稍等几分钟。
	方法二：
		在命令中指定参数webapp骨架
		mvn archetype:generate -DgroupId=com.zhangguo.mvntest04 -DartifactId=MvnTest04 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
		

## 修改pom，增加jetty插件
	<plugins>
		在笔记里面的图片maven33里面看，或者去网上找该插件。
		找到该插件放在pom.xml下的build里
	</plugins>
	运行mvn jetty ：run
	
## 在现有的项目转换成Maven项目
	具体可以看笔记的图片非maven->maven01/maven02
	如果一个非maven项目转换成maven管理的项目：只需如下操作即可。
	1、点击项目右键
	2、点击add Framework Support...	
	3、添加mvn 以及需要的配置
	4、选择允许自动导入
	5、成功转换成了一个maven项目
## 修改项目结构
	maven有一个很重要的功能是规范项目，标准的项目结构如下所示
	但是你会发现默认创建的项目是并非是完整的，如下源代码的目录没有，添加方法如下
	当前项目的结构如下：
	
	添加相应的目录，选择打开项目结构：
	蓝色：源代码
	绿色：测试
	资源文件（配置信息）
	测试资源文件
	被排除的(打包里被忽视)
	目标右键添加目录：
	
## 在IDEA中创建多模块项目
	1、创建父模块
	创建一个普通的Maven项目，不需要选择骨架(archetype)
	2、创建子模块
	子模块可以有多个，相互间可以依赖(模块)
	在父模块上右键创建一个Module
		utils
			创建普通maven项目没有骨架
		entities
			创建成一个非maven项目(当然可以是maven的)
		webapp
			创建一个基于骨架的maven WebApp项目
	3、模块间依赖
		打开项目结构
		添加模块依赖
		指定要依赖的模块
		依赖成功
		
		
	
# Maven常用命令
	一、
		a)	clean:	清理，编译后的目录
		b)	compile	：编译，只编译main目录，不编译test中的代码
		c)	test-complile：编译test目录中的代码
		d)	test：运行test里边的代码
		e)	package：打包
			1、java项目->打成jar包；
			2、web项目->打成war包；
		f)	install:发布项目到本地仓库，用在打jar包上，打成jar包可以被其他项目使用；
		e)	tomcat:run：一件构建项目；
	二、Maven命令的生命周期
		a)	clean	生命周期：clean
		b)	Default	生命周期：compile、test-compile、test、package、install
		c)	Site		生命周期：size命令，生成项目描述文档静态页；
		d)	不同的生命周期可以一起执行，例如先clean 在 compile；
	三、Maven命令的执行顺序
		a)	在相同的生命周期中的命令才会受执行顺序的影响
		b）	Default生命周期中的命令执行顺序
			compile <- test-compile <- test <-package <- install;
		
		
###Scope依赖作用域也可称作依赖范围：maven中的依赖，会根据程序所处的阶段和场景发生变化，所以maven用Scop属性来做限制;
	a)：compile（默认值）：在编译、运行、测试、打包都有效
	b)：provided：编译、测试时有效，运行、打包无效；
	c)：test：仅在测试时有效；
	d)：runtime：测试、运行、打包时有效；
	e)：system：不推荐使用，使用 system 作用域不会去本地仓库寻找依赖，要制定本地路径；
	
## part.3 Maven 3.5.4 + tomcat 8.5.32热部署
	热部署：在tomcat运行时将项目部署上去
		1、开启tomcat热部署
			a) 修改tomcat->conf->tomcat-users.xml配置文件；
			b) 在tomcat-users标签中加入以下代码
				<role rolename="manager-gui"/>
				<role rolename="manager-script"/>
				<user username="joey" password="123123" roles="manager-gui,manager-
				scripti"/>
			c) 启动tomcat;
			d) 修改项目中pom.xml,在tomcat7的插件上添加以下代码：
				<configuration>
					<url>http://localhost:8080/manager/test</url>
					<username>joey</username>
					<password>123123</password>
				</configuration>
			e) 右键项目->run as -> maven build... 在goals中使用 tomcat7:deploy 或
				tomcat7：redeploy来进行热部署；
				i.	tomcat7:deploy,第一次部署时使用。
				ii.	tomcat7:redeploy,非第一次部署时使用。
			f)	部署完毕，打开浏览器测试；		
			
## part4 Maven 整合 SSM框架：
	1、Maven+SSM框架整合：
		a)	加入SSM框架整合；
		b)	配置插件
		c)	导入SSM框架所需配置文件；
		d)	配置Maven Resources资源放行		
			i、因为Maven会把src/main/java 下的* .java文件编放到 target/classes目录
			目录中，但这目录中的其他文件不会被忽略；
			ii、Mybatis Mapper映射文件也要放在src/main/java下，所以不能忽略；
			iii、因此我们需要对src/main/java下的配置文件进行过滤，不能被忽略；
			iv、利用Maven中的Resources标签可以进行配置；
				
		
		

	