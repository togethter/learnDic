## 今日内容

	1、数据库连接池
	
	2、Spring JDBC ：JDBC Template
	
## 数据库连接池
	概念：其实就是一个容器(容器)，存放数据库连接的容器。
			当系统初始化后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取
			连接对象，用户访问完之后，将连接对象归还给容器。
	
	好处：
		1、节约资源
		2、用户访问高效
	
	3、实现：
		1、标准接口：DataSource		javax.sql包下的
			1、方法：
				* 获取连接：getConnection()
				* 归还连接：Connection.close() 如果连接对象Connection是从连接池获取的，那么调用
					Connection.close()则不会在关闭连接了，而是归还连接

			2、一般我们不去实现它，有数据库厂商实现
				1、C3P0:数据库连接池技术
				2、Druid:数据库连接池实现技术，由阿里巴巴提供的
[C3P0-jar包](https://blog.csdn.net/huangyuhua068/article/details/82086259)

[阿里巴巴-Druid-jar](https://github.com/alibaba/druid/releases/tag/1.1.23)

	4、C3P0:数据库连接池技术
		步骤：
			1、导入jar包(两个)	c3p0-0.9.5.2.jar mchange-commons-java-0.2.12.jar
			2、定义配置文件：
				*名称：c3p0.properties 或者 c3p0.config.xml
				*路径：直接将文件放在src目录下即可。
			3、创建核心对象 数据库连接池对象 combopooledDataSource
			4、获取连接：getConnection	
	5、Druid:数据库连接池实现技术，由阿里巴巴提供的
		1、 步骤
			1、导入jar包	druid-1.0.9
			2、定义配置文件：
				1、是properties形式的
				2、可以叫任意名称，可以放在任意的目录下
			3、加载配置文件。Properties	
			4、获取数据库连接池对象：通过工厂类获取 DruidDataSourceFactory
			5、获取连接getConnection 
		2、定义工具类
			1、定义一个工具类 JDBCUtils
			2、提供静态代码块加载配置文件，初始化连接池对象
			3、提供方法
				1、获取连接方法，通过数据库连接池获取连接
				2、释放资源
				3、获取连接池的方法
## Spring JDBC
[jdbcTemplate-jar包](https://blog.csdn.net/weixin_44133099/article/details/102553900)

	* spring框架对JDBC简单封装。提供了一个JDBCTemplate对象简化JDBC的开发
	* 步骤：
		1、导入jar包
		2、创建jdbcTemplate对象。依赖于数据源DataSource 			jdbcTemplate template = new jdbcTemplate(ds)
		3、调用jdbcTemplate的方法完成CRUD的操作
			* update():执行DML语句。增、删、改语句
			* queryForMap():查询结果将结果封装map集合，将列名作为key，值作为value，
				将这条记录封装为map集合， 注意这个方法查询出来的结果集长度只能是1
			* queryForList():查询结果将结果封装为List集合
				将每一条记录封装为map集合，在讲map集合装在进list集合中
			* query():查询结果，将结果封装为javarBean对象
				* query的参数：RowMapper
					* 一般我们使用BeanPropertyRowMapper可以完成数据到JvarBean的自动封装
					* new BeanPropertyRowMapper<类型 >(类型.class)
			* queryForObject:封装结果，将结果封装为对象
					*一般用于聚合函数的查询
			
		4、练习：
			*需求：
				1、需改1号数据的 salary 为10000
				2、添加一条记录
				3、删除刚才添加的记录
				4、查询id为1的记录，将其封装为Map集合
				5、查询所有记录，将其封装为List集合
				6、查询所有记录，将其封装为Emp对象的List集合
				7、查询所有记录数