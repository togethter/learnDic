##今日内容
	1、Servlet
	2、Http协议
	3、Request
	
##Servlet
		1、概念
		2、步骤
		3、执行原理
		4、生命周期
		5、servlet3.0 注解配置
		6、servlet体系结构
			servlet -- 接口
				|
			GenericServlet -- 抽象类
				|
			HttpServlet   -- 抽象类
			
		* GenericServlet:将servlet接口中的其他方法做了默认空实现，只将service()方法作为抽象
			* 将来定义Servlet类时，可以继承GenericServlet，实现service()方法即可
			* 
		* HttpServlet：对http协议的一种封装，简化操作
			1、定义类继承HttpServlet
			2、复写doGet/doPost方法
		7、Servlet相关配置
			1、urlpartten:Servlet访问路径
				1、一个Servlet可以定义多个访问路径：@webServlet({"/d4","/dd4","/ddd4"})
				2、路径定义规则：
					1、/xxx
					2、/xxx/xxx:多层路径，目录结构
					3、*.do
				
##Http
		*观念：Hyper Text Transfer Protocol 超文本传输协议
			*传输协议：定义了客户端和服务器端通信时，发送数据的格式
			*特点：
				1、基于TCP/IP的高级协议
				2、默认端口号是80
				3、基于请求/响应模型的，一次请求对应一次响应
				4、无状态的：每次请求之间相互独立，不能交互数据
			*历史版本
				1.0：每一次请求响应都会建立新的连接
				1.1：复用连接
			
		*请求消息数据格式
			1、请求行
				请求方式 请求url 请求协议/版本
				GET /Login.html HTTP/1.1

				* 请求方式：
					HTTP协议有7中请求方式，常用的有两种
						*GET
							1、请求参数在请求行中，在url后
							2、请求的url长度是有限度的
							3、不太安全
						*POST
							1、请求参数在请求体中
							2、请求的url长度是没有限度的
							3、相对安全
			2、请求头：客户端浏览器告诉服务器一些信息 
				请求头名称:请求头值
				*常见的请求头
					1、User-Agent：浏览器告诉服务器，我访问你使用的浏览器的版本信息
						*可以在服务器端获取该头的信息，解决浏览器的兼容问题
					2、Referer: http://localhost:8080/login.html
						*告诉服务器，我(当前的请求)从哪里来？
							*作用：
								1、防盗链：
								2、统计工作
								
			3、请求空行
				空行，用于分割post请求的请求头和请求体的。
			4、请求体(正文)
				* 封装POST请求消息的请求参数的
			
			* 字符串格式：
				GET /Login.html HTTP/1.1
		*响应消息数据格式
##Request		
	1、request对象和response对象的原理
		1、request和response是由服务器创建的。我们使用他们而已
		2、request对象是来获取请求消息，response对象是来设置响应消息
		
	2、request对象继承体系结构：
		ServletRequest		---接口
			|
		HttpServletRequest 	---接口
			|
		org.apache.catalina.connector.RequestFacade@1de91c91 类(tomcat）
	
	3、request功能：
		1、获取请求消息
			1、获取请求行数据
				* GET /day/demo1?name=zhangsan HTTP/1.1
				* 方法：
					1、获取请求方式：GET
						* String getMethod()
					2、(*)获取虚拟目录：/day
						* String getContextPath()
					3、获取Servlet路径：demo1
						* String getServletPath()
					4、获取get方式的请求参数：name=zhangsan
						 * String getQueryString()
					5、(*)获取请求的URI: /day/demo1
						* String getRequestURI()：/day/demo1
						* String getRequestURL()：http://localhost/day/demo1
						* URL:统一资源定位符：/day/demo1                        中华人民共和国
						* URI:统一资源标识符：http://localhost/day/demo1   共和国
					6、获取协议和版本： HTTP/1.1 
						* String getProtocol()
					7、获取客户机的IP地址：
					 	* String getRemoteAddr():
					 	
			2、获取请求头数据
				*方法
					*(*)String getHeader(String name)：通过请求头的名称来获取请求头的值
					*Enumeration<String> getHederNames()获取所有的请求头名称
			3、获取请求体数据
				*请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的参数
				*步骤：
					1、获取流对象
						*BufferedReader getReader():获取字符输入流，只能操作字符数据
						*ServletInputStream getInputStream():获取字节输入流，可以操作所有类型的数据
							*在文件上传知识点讲解
					2、在从流对象中拿数据
					3、
		2、其他功能：
			1、获取请求参数通用方式
				1、String getParameter(String name)：根据参数名称来获取参数 username=zs&password=1234
				2、String[] getParameterValues(String name)：根据参数名称获取参数值的数组 
					hobby=xx&hobby=game	
				3、Enumeration<String> getParameterNames()：获取所有请求的参数名称				4、Map<String,String[]> getParameterMap():获取所有参数的map集合
				*中文乱码问题：
					get方式：tomcat 8 已经将get方式乱码问题解决了
					post方式： 会乱码
						*解决:在获取参数前，设置request的编码 request.setCharacterEncoding("utf-8");
			2、请求转发：一种在服务器内部的资源跳转方式
				1、步骤：
					1、通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String parth)
					2、使用RequestDispatcher对象来进行转发：
						forward(ServletRequest request,ServletResponse response)
				2、特点：
					1、浏览器地址栏路径不发生变化
					2、只能转发当前服务器内部资源中。
					3、转发是一次请求		
			3、共享数据
				*域对象：一个有作用范围的对象，可以在范围内共享数据
				*request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
					*方法：
					    1、 void setAttribute(String name,Object obj):存储数据
					    2、Object getAttribute(String name):通过键获取值
					    3、void removeAttribute(String name)：通过键移除键值对
			4、获取servletContext
				*ServletContext getServletContext();
## 案例：用户登录				
	*用户登录需求
		1、编写login登录页面 username&password两个输入框
		2、使用Druid数据库连接池技术，操作mysql,数据库表中的user表
		3、使用jdbcTemplate技术封装jdbc
		4、登录成功跳到successServlet展示：登录成功！用户名，欢迎您
		5、登录失败跳到FailServlet展示：登录失败，用户名或密码错误
		
[BeanUtils下载工具](http://commons.apache.org/proper/commons-beanutils/download_beanutils.cgi)		
		*分析
		*开发步骤：
			1、创建项目，导入html页面，配置文件，jar包
			2、创建数据库环境
				CREATE DATABASE day14;
				USE day14;
				CREATE TABLE USER(
				id INT PRIMARY key auto_increment,
				username VARCHAR(32) UNIQUE NOT NULL,
				password VARCHAR(32) NOT NULL
				);
			3、创建包cn.itcast.domain,创建类User
				package cn.itcast.domain;
				/**
				 * 用户的实体类
				 */
				public class User {
				    private int id;
				    private String username;
				    private String password;
				
				    public int getId() {
				        return id;
				    }
				
				    public void setId(int id) {
				        this.id = id;
				    }
				
				    public String getUsername() {
				        return username;
				    }
				
				    public void setUsername(String username) {
				        this.username = username;
				    }
				
				    public String getPassword() {
				        return password;
				    }
				
				    public void setPassword(String password) {
				        this.password = password;
				    }
				    @Override
				    public String toString() {
				        return "User{" +
				                "id=" + id +
				                ", username='" + username + '\'' +
				                ", password='" + password + '\'' +
				                '}';
				    }
				}	
			 4、创建cn.itcast.util，创建JDBCUtils，提供封装jdbc方法
				/**
				 * JDBC的工具类 使用Durid连接池
				 */
				public class JDBCUtils {
				    private static DataSource ds;
				    static {
				        try {
				            // 1、加载配置文件
				            Properties pro = new Properties();
				            // 使用ClassLoad加载配置文件，获取字节输入流
				            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
				            pro.load(is);
				            // 2、初始化连接池对象
				            ds =  DruidDataSourceFactory.createDataSource(pro);
				        } catch (IOException e) {
				            e.printStackTrace();
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				    }
				    /**
				     * 获取连接池对象
				     */
				    public static DataSource getDataSource(){
				        return ds;
				    }
				    /**
				     * 获取连接Connection对象
				     */
				    public static Connection getConnection() throws SQLException {
				        return ds.getConnection();
				    }
				}	
			5、创建包cn.itcast.dao,创建类User	Dao	,提供login的方法
					/**
					 * 操作数据库中User表的表
					 */
					public class UserDao {
					    // 声明 JDBCTemplate对象共用
					    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
					    /**
					     * 登录方法
					     * @param loginUser 只有用户名和密码
					     * @return user包含用户全部数据,没有查询到，返回null
					     */
					    public User login(User loginUser) {
					        try {
					            //1 编写sql
					            String sql = "select *from user where username = ? and password = ?";
					            //2 调用query方法
					            User user = template.queryForObject(sql,
					                    new BeanPropertyRowMapper<User>(User.class),
					                    loginUser.getUsername(),
					                    loginUser.getPassword());
					            return user;
					        } catch (Exception e) {
					            e.printStackTrace(); // 记录日志
					            return null;
					        }
					    }
					}
			  6、编写cn.itcast.web.servlet.LoginServlet类
				 @WebServlet("/loginServlet")
				public class LoginServlet extends HttpServlet {
				    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
				    ServletException, IOException {
				    }
				    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
				    ServletException, IOException {
				        //1 设置编码
				        request.setCharacterEncoding("utf-8");
				        //2 获取请求参数
				        String username = request.getParameter("username");
				        String password = request.getParameter("password");
				        //3 封装user对象
				        User loginUser = new User();
				        loginUser.setUsername(username);
				        loginUser.setPassword(password);
				        loginUser.setId(1);
				        //4 调用UserDao的login方法
				
				        UserDao dao = new UserDao();
				        User user = dao.login(loginUser);
				        //5 判断user
				        if (user == null){
				            // 登录失败
				            request.getRequestDispatcher("/failServlet").forward(request,response);
				        } else {
				            // 登录成功
				            // 存储数据
				            request.setAttribute("user",user);
				            request.getRequestDispatcher("/successServlet").forward(request,response);
				        }
				    }
			  7、login.html中form表单的action路径的写法
			  	* 虚拟目录+servlet的资源路径
			  8、BeanUtils工具类，简化数据封装
			  	* 用于封装JavaBean的
			  		1、javaBean:标准的java类
			  			1、要求
				  			1、类必须被public修饰
				  			2、必须提供空参的构造器
				  			3、成员变量必须使用private修饰
				  			4、提供公共的setter和getter方法
				  		2、功能：封装数据
				  	2、概念
				  		成员变量：
				  		属性：setter和getter方法截取后的产物
				  			例如：getUsername() ->Username->username
				  	3、方法：
				  		1、setProperty()
				  		2、getProperty()			
				  		3、populate(object obj,Map map):将map集合的键值对信息,封装到对应的JavaBean对象中
			  			
