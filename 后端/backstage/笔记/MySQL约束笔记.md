#今日内容
		
1. DQL：查询语句
	
		* 	1.排序查询
		* 	2.聚合函数
		* 	3.分组查询
		* 	4.分页查询
	
2. 约束	
3. 多表之间的关系
4. 范式
5. 数据库的备份和还原

	
## DQL：查询语句
	1.排序查询
		* 	语句：order by 子句
		       * 	order by 排序字段1 排序方式1，排序字段2 排序方式2
		* 	排序方式
				*ASC：升序，默认的。
				*DESC：降序，默认的。
		*注意：
			*当多个排序条件，则当前面的排序条件值一样的时，才会判断第二个条件。		
	2.聚合函数：将一列数据作为一个整体，进行纵向的计算。
		1.count：计算个数
			1.一般选择非空的列主键
			2.count(*)
		2.max:	计算最大值
		3.min:	计算最小值
		4.sum：	计算求和
		5.avg:	计算平均值
		*注意：聚合函数会排除null值。
			解决方案：
				1.选择不包含非空的列进行计算
				2.IFNULL函数	
	3.分组查询
		1、语法: group by 分组字段;
		2、注意：
			1、分组之后查询的字段：分组字段，聚合函数
			2、where和having的区别？
				1、where在分组之前进行限定，如果不满足条件，则不参与分组,having是在分组之后进行限定，如果不满足结果，则不会查询出来。
				2、where后不可以跟聚合函数，having可以聚合函数的判断
	4.分页查询
		1、语法：limit 开始的索引，每页查询的条数；
		2、公式：开始的索引 = （当前的页码 - 1）* 每页显示的条数
		-- 每页显示三条记录
		SELECT * FROM student3 LIMIT 0,3; -- 第一页
		SELECT * FROM student3 LIMIT 3,3; -- 第二页
		SELECT * FROM student3 LIMIT 6,3; -- 第三页
		3、limit操作是一个MySQL"方言"
## 约束
	*概念：对表中的数据进行限定，保证数据的正确性、有效性和完整性。
	*分类：
		*主键约束 primary key
		*非空约束 not null
		*唯一约束 unique
		*外键约束 foreign key
		
	*非空约束：not null
		1、 创建表时添加约束
			CREATE TABLE stu1(
			id INT,
			NAME VARCHAR(20) NOT NULL -- name为非空
			);
		2、 创建表后添加非空约束
			ALTER TABLE stu1 MODIFY NAME VARCHAR(20) NOT NULL;
		3、 删除 name 的非空约束
			ALTER TABLE stu1 MODIFY NAME VARCHAR(20);	
	*唯一约束：unique，值不能重复
		1、创建表的时候添加唯一约束
			CREATE TABLE stu2(
			id INT,
			phone_number VARCHAR(20) UNIQUE -- 添加了唯一约束
			);
			* 注意mysql中，唯一约束限定的列的值可以有多个null
		2、 删除唯一约束
			ALTER TABLE stu2 DROP INDEX phone_number;
		3、创建表后，添加唯一约束
			ALTER TABLE stu2 MODIFY phone_number VARCHAR(20) UNIQUE;
	*主键约束 primary key
		1、注意：
			1.含义：非空且唯一
			2.一张表只能有一个字段为主键
			3.主键就是表中记录的唯一标识
		2、创建表时添加主键约束
		create table stu(
		id int primary key ,-- 给id添加主键约束
		name varchar(20)
		);			
		3、删除主键
		-- 错误 ALTER TABLE stu3 MODIFY id INT;
		ALTER TABLE stu3 DROP PRIMARY KEY;
		4、创建完表后 添加主键
		ALTER TABLE stu3 MODIFY id INT PRIMARY KEY;
		5、自动增长：
			1、概念：如果某一列是数值类型的，使用auto_increment 可以完成值的自动增长
			2、在创建表时，添加主键约束，并且完成主键自增长
				create table stu3(
					id int primary key auto_increment ,-- 给id添加主键约束
					name varchar(20)
				);	
			3、删除自动增长
			ALTER TABLE stu4 MODIFY id INT;
			4、添加自动增长
			ALTER TABLE stu4 MODIFY id INT auto_increment;
	*外键约束 foreign key 让表于表长生关系，从而保证数据的正确性
		1、在创建表时可以添加外键约束
			* 语法：
			  create table 表名称 (
			  ...
			  外键列 
			  constraint 外键名称 foreign key (外键列的名称) references 主表名称(主表列名称)
			  );
		2、删除外键
		ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
		3、创建表之后，添加外键
		ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY(外键字段) REFERENCES department 主表名称(主表列名称);
		4、级联操作
			1、语法：ALTER TABLE 表名 ADD CONSTRAINT 外键名称 Foreign key (外键字段名称) references (主表名称) on update cascade on delete cascade;
			2、分类：
				1、级联更新：on update cascade
				2、级联删除：on delete cascade
##数据库的设计

	1、多表之间的关系
		1、分类：
			1、一对一的关系
				* 人和身份证
				* 分析：一个人只有一个身份证，一个身份证也只有一个人
			2、一对多(多对一)
				 * 如：部门和员工
				 * 分析：一个部门有多个员工，一个员工只能对应一个部门
			3、多对多：
				* 如：学生和课程
				* 分析：一个学生可以选择很多门课程，一个课程也可以被很多部门选择
		2、实现关系：
			1、一对多(多对一):
				*部门和员工
				*实现方式：在多的一方建立外键，指向一的一方的主键。
			2、多对一
				*如：学生和课程
				*实现方式：多对多实现需要借助第三张表，中间表至少包含两个字段，这两个字段作为作为第三张表的外键，分表指向两张表的主键
			3、一对一(了解)：
				*如：人和身份证
				*实现方式：一对一关系，可以在任意一方添加唯一外键指向另一方主键。
		3、案例		
			1、创建旅游分类表
				<!-- cid 旅游线路分类主键，自动增长
				 cname 旅游线路分类名称非空，唯一，字符串 100-->
				CREATE TABLE tab_category(
					cid INT PRIMARY KEY auto_increment,
					cname VARCHAR(100) NOT NULL UNIQUE
				);
			2、创建旅游线路表
				<!--rid 旅游线路主键，自动增长
				rname 旅游线路名称非空，唯一 字符串 100
				price 价格
				rdate 上架日期 日期格式
				 cid 外键 所属分类-->
				CREATE TABLE tab_route(
					rid INT PRIMARY KEY auto_increment,
					rname VARCHAR(100) NOT NULL UNIQUE,
					price DOUBLE,
					rdate DATE,
					cid INT,
					FOREIGN KEY (cid) REFERENCES tab_category (cid)
				);
				
			 3、创建用户表
				<!-- uid 用户主键，自增
				 username 用户名字长度 100 唯一 非空
				 password 密码长度30 非空
				 name 真实姓名长度 100
				 birthday 生日
				 sex 性别 定长字符串1
				 telephone 手机号，字符串长度 11
				 email 邮箱 字符串长度100-->
				CREATE TABLE tab_user(
					uid INT PRIMARY KEY auto_increment,
					username VARCHAR(100) NOT NULL UNIQUE,
					password VARCHAR(30) NOT NULL,
					name VARCHAR(100),
					birthday DATE,
					sex VARCHAR(1) DEFAULT '男',
					telephone VARCHAR(11),
					email varchar(100)
				);
			   4、创建收藏表
				<!--rid 旅游线路id 外键
				date 收藏时间
				uid 用户id，外键
				rid 和 uid 不能重复，设置复合主键，同一个用户不能收藏同一个线路两次-->
				CREATE TABLE tab_favorite(
					rid INT,
					date datetime,
					uid INT,
					-- 创建复合主键
					PRIMARY KEY (rid,uid),
					foreign key(rid) references tab_route(rid),
					foreign key(uid) references tab_user(uid)
				);
	2、数据库设计的范式			
			*概念：设计数据时，需要遵循一些规范。要遵循后边的范式要求，必须必须遵循前面的所有范式要求
				设计关系数据库时，遵从不同规范的要求，设计出合理的关系型数据库，这些不同的规范要求被称为不同的
				规范，各种范式呈递次规范，越高的范式数据库冗余越小。
				目前关系数据库有六种范式，第一范式(1NF), 第二范式(2NF)，第三范式(3NF)，巴斯-课的范式(BCNF)，第五范式(5NF)，
				第六式(6NF 又称完美范式)
			*分类：
				1、第一范式(1NF)，每一列都是不可分割的原子数列项
				2、第二范式(2NF)，在第一范式基础上，非码属性必须完全依赖与码，(在1NF基础上消除非主属性
				对主码的的部分函数依赖)
					几个概念：
						1、函数依赖：A->B,如果通过A属性(属性组)的值，可以确定唯一B属性的值。则称B依赖于A
						例如：学号->姓名，(学号,课程)->分数
						2、完全函数依赖：如果A是一个属性组，则B属性值的确定，需要依赖于A属性组中的所有属性值
						例如：(学号，课程名称)->分数
						3、部分函数依赖：如果A是一个属性组，则B属性值的确定只需要依赖于A属性组的的某一些的
						值即可
						例如：(学号，课程名称)-> 姓名
						4、传递函数依赖：A-->B,B-->C,如果通过A属性(属性组)的值，可以确定唯一B属性(属性组)的值，在通过B属性
						的值可以唯一确定C属性的值，则称为C函数传递依赖于A
						例如：学号->系名，系名->系主任
						5、码：如果在一张表中，一个属性或属性组，被其他所有的属性所依赖，则称这个属性(属性值)
						为该标的码
							例如：该表码为：(学号，课程名称)
							
							主属性：码属性组中的所有属性
							非主属性：除过码属性组的属性
						
				3、第三范式(3NF)，在第二范式基础上，任何非主属性，不依赖于其他的非主属性(在2NF基础上消除传递
				依赖)
##数据库的备份和还原			
	1、命令
		*命令：mysqldump -u用户名 -p密码 数据库名称 > 保存的路径
		*还原：
			1、登录数据库
			2、创建数据库
			3、使用数据库
			4、执行文件 source 文件路径
	2、图形化工具
						 	
			
			
				





























		