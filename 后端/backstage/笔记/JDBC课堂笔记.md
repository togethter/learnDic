## 今日内容
	1、JDBC基本概念
	2、快速入门
	3、对JDBC中各个接口和类详解

## JDBC：
[驱动Jar包-jdbc](https://www.jianshu.com/p/3cae846b8a91)

	*1、概念：Java DataBase Connectify java数据库连接，java语言操作数据库
	*JDBC本质：其实是官方(Sun公司)定义了一套操作所有关系型数据库的规则，即接口。各个数据库厂商取	
	实现这套接口，提供数据库驱动jar包，我们可以使用这套接口(JDBC)编程 ,真正执行的代码是驱动jar包中的实现类
	*2、快速入门：
		*步骤：
			1、导入驱动jar包,mysql-connector-java-8.0.21.jar
				1、赋值mysql-connector-java-8.0.21.jar到项目libs目录下
				2、右键---> add as Library
			2、注册驱动
			3、获取数据库的连接对象 Connection
			4、定义sql
			5、获取执行SQL语句的对象 Statement 
			6、执行SQL，接收返回结果
			7、处理结果
			8、释放资源
			
		案例
	        
     		-- 1、导入驱动jar包
	  	-- 2、注册驱动
	        Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver'. 
	        This is deprecated.
	       -- 3、获取数据库连接对象
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", 
	        "root", "qwe123456");
	      	 -- 4、定义sql语句
	        String sql = "update account set balance = 8000 where id = 1";
	       -- 5、获取执行sql的对象 Statement
	        Statement stmt = connection.createStatement();
	       -- 6、执行sql
	        int count = stmt.executeUpdate(sql);
	       -- 7、处理结果
	        System.out.println(count);
	       -- 8、释放资源
	        stmt.close();
	        connection.close();
	*3、详解各个对象
		1、DriverManager：驱动管理对象
			*功能
				1、注册驱动：告诉程序该使用哪一个数据库驱动jar 
				static void registerDriver(Driver driver):注册与给定的驱动程序 DriverManager
				写代码使用：Class.forName("com.mysql.cj.jdbc.Driver");
				通过查看源码发现：在com.mysql.cj.jdbc.Driver类中存在静态代码块
				    static {
				        try {
				            DriverManager.registerDriver(new Driver());
				        } catch (SQLException var1) {
				            throw new RuntimeException("Can't register driver!");
				        }
				    }
				    注意：mysql5之后的驱动jar包可以省略注册驱动的步骤
				    
				2、获取数据库连接
				* 方法 static Connection getConnection(String url,String user,String password)
					参数：
						url:指定的连接路劲
							语法：jdbc:mysql://ip地址(域名):端口号/数据库名称
							例子：jdbc:mysql://localhost:3306/db3
							细节：如果连接的时本机的mysql服务器，并且mysql服务默认端口是3306
							则url可以简写为：jdbc:mysql:///数据库名称
						user：用户名
						password：密码
		2、Connection：数据库连接对象
			1、功能：
				1、获取执行sql的对象
					* Statement createStatement()
					* PreparedStatement prepareStatement(String sql)
				2、管理事务
					* 开启事务: setAutoCommit(bolean autoCommit) 调用该方法设置参数为false
					即开启事务
					* 提交事务: commit()
					* 回滚事务:rollback()
		3、Statement：执行sql对象
			1、执行sql
				1、bolean execute(String sql):可以执行任意的sql 了解
				2、int executeUpdate(String sql):执行DML(insert,delete,update)语句 
				DDL(create、alter、drop)语句
					*返回值：影响的行数，可以通过这个影响的行数来判断 DML语句是否执行成功 
					返回值>0的则执行成功，否则执行失败
				3、ResultSet executeQuery(String sql):执行DQLSELECT语句			2、练习
				1、account表 添加一条记录
				2、account表 修改记录
				3、account表 删除一条记录
		4、ResultSet：结果集对象
			*next():游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果是，则返回
			false，如果不是则返回ture
			
			*getxxx(参数):获取数据
				*xxx 代表数据类型 如果 Int getInt()	, String getString()
					1、Int：代表列的编号 从1开始 如：getString(1)
					2、String：代表列的名称。如：getDouble("balacne")
				*使用步骤
					1、游标向下移动一行
					2、判断是否有数据
					3、获取数据	
						  while (rs.next()) {
				                // 获取数据
				                int id = rs.getInt(1);
				                String name = rs.getString("name");
				                double balance = rs.getDouble(3);
				                System.out.println(id + "---" + name + balance);
				            }
				            
			*练习：
			 *查询emp表的数据将其封装为对象,然后装载集合，返回。
			 	1、定义emp类
			 	2、定义方法 public list<emp>findAll(){}
			 	3、实现方法 select *from emp;
			 
				            
		5、PreparedStatement ：执行sql对象
			1、SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。
			会造成安全性问题
				1、输入用户名随便，输入密码：a' or 'a' = 'a 
				     select *from user where username = 'dasdad' and password = 'a' or 'a' = 'a' 
			2、解决sql注入问题：使用PreparedStatement对象来解决
			3、预编译SQL:参数使用？作为占位符
			4、步骤：
					1、导入驱动jar包,mysql-connector-java-8.0.21.jar
					2、注册驱动
					3、获取数据库的连接对象 Connection
					4、定义sql
						* 注意：sql参数使用? 作为占位符。如：select *from user where username = ? 
						* and password = ?;
					5、获取执行SQL语句的对象 PreparedStatement  Connection.prepareStatement()					6、给?赋值：
						* 方法：setXxx(参数1，参数2)
							参数1：？位置编号 从1开始
							参数2：？的值
					7、执行SQL，接收返回结果
					8、处理结果
					9、释放资源
			5、注意：后期都会使用PreParedStatement来完成增删改查的所有操作
				1、可以防止SQL注入
				2、效率更高
					   
		
## 抽取JDBC工具类、JDBCUtils
	* 目的：简化书写
	* 分析：
		1、注册驱动也抽取
		2、抽取一个方法获取连接对象
			*需求：不想传递参数(麻烦)，还得保证工具类的通用性
			*解决：配置文件 
				jdbc.properties
					url=
					uer=
					password=
		3、抽取一个方法释放资源
				public class JDBCUtils {
				    private static String url;
				    private static String user;
				    private static String password;
				    private static String driver;
				
				    /**
				     * 文件的读取，只需要读取一次即可。使用静态代码块
				     */
				
				    static {
				        try {
				            // 读取资源文件，获取值
				            //1、创建Property集合类
				            Properties pro = new Properties();
				            // 获取src路径下的文件的方式->ClassLoader
				            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
				            // URL res = classLoader.getResource("jdbc.properties");
				            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
				            //2 加载文件
				            pro.load(is);
				            //3 获取数据，赋值
				            url = pro.getProperty("url");
				            password = pro.getProperty("password");
				            user = pro.getProperty("user");
				            driver = pro.getProperty("driver");
				            //4 注册驱动
				            Class.forName(driver);
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				    }
				
				    /**
				     * 获取连接
				     *
				     * @return 连接对象
				     */
				    public static Connection getConnection() throws SQLException {
				        return DriverManager.getConnection(url, user, password);
				    }
				
				    public static void close(Statement stmt, Connection conn) {
				        if (stmt != null) {
				            try {
				                stmt.close();
				            } catch (SQLException throwables) {
				                throwables.printStackTrace();
				            }
				        }
				        if (conn != null) {
				            try {
				                conn.close();
				            } catch (SQLException throwables) {
				                throwables.printStackTrace();
				            }
				        }
				    }
				
				    public static void close(ResultSet rs, Statement stmt, Connection conn) {
				        if (rs != null) {
				            try {
				                rs.close();
				            } catch (SQLException throwables) {
				                throwables.printStackTrace();
				            }
				        }
				        if (stmt != null) {
				            try {
				                stmt.close();
				            } catch (SQLException throwables) {
				                throwables.printStackTrace();
				            }
				        }
				        if (conn != null) {
				            try {
				                conn.close();
				            } catch (SQLException throwables) {
				                throwables.printStackTrace();
				            }
				        }
				    }
			}

	练习：
		* 需求
			1、通过键盘录入用户名和密码
			2、判断用户是否是否登录成功
				*select *from user where username = '' and password = '';
				*如果这个sql有查询结果，则成功，反之，则失败
			
		*步骤
			1、创建数据库表	user表	
				CREATE TABLE USER(
					id INT PRIMARY KEY auto_increment,
					username VARCHAR(32),
					PASSWORD VARCHAR(32)
				);
				
			INSERT INTO `USER` VALUES(NULL,'zhangsan','123');
			INSERT INTO `USER` VALUES(NULL,'lisi','234');
			2、

		
## JDBC控制事务:
	1、事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则多个步骤要么同时成功，要
	么同时失败
	2、事务的操作
		1、开启事务
		2、提交事务
		3、回滚事务
	3、使用Connection对象来管理事务
		1、开启事务:setAutoCommit(boolean autoCommit):调用该方法设置参数为false,即开启事务
			* 在执行sql之前开启事务
		2、提交事务:commit();
			*当所有sql都执行完提交事务
		3、回滚事务:rollback();
			*在catch中回滚事务

		
	 
			
		
	
	
	