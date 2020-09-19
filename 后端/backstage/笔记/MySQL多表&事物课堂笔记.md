# 今日内容

1、多表查询

2、事物

3、DCL

## 多表查询：
	* 查询语法
		select 
			列名列表
		from
			表名列表
		where....
	*  准备sql

 		*  创建部门表
	CREATE TABLE dept(
		id INT primary key auto_increment,
		NAME varchar(20)
	);
	
	INSERT INTO dept(NAME)VALUES('开发部'),('市场部'),('财务部');
		* 创建员工表
	CREATE TABLE emp(
		id INT PRIMARY KEY auto_increment,
		NAME VARCHAR(10),
		gender VARCHAR(1), -- 性别
		salary DOUBLE, -- 工资
		join_date DATE,
		dept_id INT,
		FOREIGN KEY (dept_id) REFERENCES dept(id) -- 外键关联部门表（部门表的名）
	);
	INSERT INTO emp (NAME,gender,salary,join_date,dept_id)VALUES('孙悟空','男',7200,'2013-02-24',1);
	INSERT INTO emp (NAME,gender,salary,join_date,dept_id)VALUES('猪八戒','男',3600,'2010-12-02',1);
	INSERT INTO emp (NAME,gender,salary,join_date,dept_id)VALUES('唐僧','男',9000,'2008-08-08',1);
	INSERT INTO emp (NAME,gender,salary,join_date,dept_id)VALUES('白骨精','女',5000,'2015-10-17',1);
	INSERT INTO emp (NAME,gender,salary,join_date,dept_id)VALUES('蜘蛛精','女',4500,'2011-03-14',1);
	
	-- 笛卡尔积 A，B
		*有两个集合 A ，B，取这两个集合的所有组成情况。
		*要完成多表查询需要消除无用的数据
	-- 消除无用的数据
	* 多表查询的分类：
		1、内连接查询：
			1、隐式内连接：使用where条件消除无用数据
				*例子
					* 查询员工表的名称，姓名。部门表的名称
					SELECT emp.NAME,emp.gender,dept.NAME FROM emp,dept WHERE emp.dept_id = dept.id;
					
					SELECT 
					t1.`NAME`, -- 员工表的姓名
					t1.gender, -- 员工表的性别
					t2.`NAME`	-- 部门表的名称
					FROM
					emp t1, dept t2
					WHERE t1.dept_id = t2.id;
			2、显式内连接：
				*语法：select 字段列表 from 表名1 [inner] join 表名2 on 条件
				例如
					SELECT *FROM emp INNER JOIN dept ON emp.dept_id = dept.id;
					SELECT *FROM emp  JOIN dept ON emp.dept_id = dept.id;
			3、内连接查询
				1、从哪些表中查询数据
				2、条件是什么
				3、查询哪些字段		
		2、外连接查询：
			1、右外连接：
			*语法 select 字段列表 from 表1 Right [outer] join 表2 on 条件
			*查询的时右边的所有数据以及其交集部分。
			2、左外链接：
			*语法 select 字段列表 from 表1 left [outer] join 表2 on 条件
			*查询的时左边的所有数据以及其交集部分。
		3、子查询：
			*概念：查询中嵌套查询，称嵌套查询为子查询。
				查询工资最高的员工信息
				1、查询工资最高的工资是多少 9000
				SELECT MAX(salary) FROM emp;
				2、查询员工信息，并且工资等于9000
				SELECT * FROM emp WHERE salary = 9000;
				3、一条sql就完成这个操作，子查询
				SELECT *FROM emp WHERE salary = (SELECT MAX(salary) FROM emp);
			*子查询的不同情况
				1、子查询的结果是单行单列：
					*子查询可以作为条件，使用这些运算符可以判断。使用的运算符 > >= < <= =
						-- 查询员工的工资小于平均工资的 
						SELECT *FROM emp WHERE salary < (SELECT AVG(salary) FROM emp);
				2、子查询的结果是多行单列的：
					*子查询可以作为条件,使用运算符in来判断
						-- 查询'财务部'和 ‘市场部’所有的员工信息
					SELECT id FROM dept WHERE `name` = '财务部' OR `name` = '市场部';
					SELECT *FROM dept WHERE id  = 3 OR id = 2;
					SELECT *FROM dept WHERE id in (SELECT id FROM dept WHERE `name` in('财务
					部' ,`name` = '市场部'));
				3、子查询的结果是多行多列的：
					*子查询可以作为一张虚拟表来参与查询
					-- 查询员工的入职日期是2011-11-11之后的员工信息和部门信息
					SELECT *FROM dept t1,(SELECT *FROM emp WHERE emp.join_date > 
					'2011-11-11') t2 WHERE t1.id = t2.dept_id;
					-- 普通内连接
					SELECT *FROM emp t1, dept t2 WHERE t1.dept_id = t2.id AND t1.join_date > 
					'2011-11-11';
				
				
				
##	事物
	1、事务的基本介绍
		1、概念：
			*如果一个包含多个步骤的业务的操作，被事务管理，那么这些操作要么同时成功，要么同时失败。
		2、操作
			1、开启事务：start transaction;
			2、回滚：rollback;
			3、提交：commit;
				例子：
				CREATE TABLE account(
					id INT PRIMARY KEY auto_increment,
					NAME VARCHAR(10),
					balance DOUBLE
				);
				INSERT INTO account(`NAME`,balance)VALUES('张三',1000),('李四',1000);
				SELECT *FROM account;
				UPDATE account SET balance = 1000;
				-- 给张三账户转账 500元
				-- 0 开启事务
				START TRANSACTION;
				-- 1 张三账户 -500
				UPDATE account SET balance = balance - 500 WHERE NAME = '张三';
				-- 2 李四账户 +500
				UPDATE account SET balance = balance + 500 WHERE NAME = '李四';
				-- 发现没有问题提交事务
				COMMIT;
				-- 4 发现出问题了需要回滚事务
				ROLLBACK;
			4、在MySQL数据库中默认事务自动提交
 					*事务提交的两种方式：
						1、自动提交
							mysql就是自动提交的
							一条DML(增删改)语句会自动提交一次事务
						2、手动提交:
							1、Oracle数据库默认是手动提交事务
							2、需要手动开启事务，在提交
							
					*修改事务的默认提交方式	
						*查看事务的默认提交方式：SELECT @@autocommit; -- 1 代表自动提交 0代表手动
						提交
						*修改默认提交方式：set @@autocommit = 0;
	2、事务的四大特征
		1、原子性：是不可分割的最小操作单位，要么同时成功，要么同时失败
		2、持久性：当事务提交或回滚后，数据库会持久化的保存数据
		3、隔离性：多个事务之间。相互独立。
		4、一致性：事务操作前后，数据总量不变。
	3、事务的隔离级别(了解)
		*概念：多个事务是隔离的，相互独立的。但是如果多个事务如果同时操作同一批数据，则会引发一些问
		题，设置不同的隔离级别，就可以解决这些问题。
		*存在问题：	
			1、脏读：一个事务，读取到另一个事务中没有提交的数据，
			2、不可重复度(虚读)：同一个事务中，两次读取到的数据不一样。
			3、 幻读：一个事务操作(DML)数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询
			不到自己的修改
		*隔离级别：
			1、read uncommitted:读未提交
				产生问题：脏读、不可重复度(虚读)、幻读
			2、read committed:读已提交(Oracle默认)
				产生问题：不可重复度(虚读)、幻读	
			3、repeatable read:可重复度（MySQL默认）
				产生问题：幻读	
			4、serializable:串行化
				可以解决所有问题	
			*注意：隔离级别从小到大安全性越来越高，但是效率越来越低
			*数据库查询隔离级别
				* select @@tx_isolaction(有些版本查询)
				* select @@transaction_isolation;(navicat 查询)
			*数据库设置隔离级别
				 * set global transaction isolaction level 级别字符串;
							
	
	
	
	
##DCL:
	 * SQL分类：	
		1、DDL:操作数据库和表
		2、DML：增删改表中的数据的
		3、DQL：查询表中的数据的
		4、DCL：管理用户，授权
	
	* DBA：数据库管理员
	*  DCL: 管理用户，授权
			1、管理用户
				添加用户：
					语法：CREATE USER '用户名' @'主机名' IDENTIFIED BY '密码';
				删除用户：
					语法：DROP USER '用户名' @'主机名';
				修改用户的密码：
					UPDATE USER SET PASSWORD PASSWORD('新密码') WHERE USER = '用户名';
					UPDATE USER SET `password` PASSWORD('abc') WHERE USER = 'lisi';
					update user set password=password("abc") where user="root";
					SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
					SET PASSWORD FOR 'lisi'@'%' = PASSWORD('abc');
					
					在mysql中忘记root用户密码？
						1、cmd -> net stop mysql 停止mysql服务
							* 需要以管理员权限
						2、使用无验证启动mysql服务：mysql -- skip-grant-tables
						3、在新的cmd 中修改密码
						4、手动结束mysql服务，关闭窗口
						5、在新的cmd 中启动mysql服务
						6、用新的密码登录
						
				查询用户：
					-- 1、切换到mysql数据库
					USER mysql;
					-- 2、查询user表
					SELECT *FROM USER;
					* 通配符 % 表示可以在任意主机使用用户登录登录数据库
					
			2、授权
				1、查询权限
					-- 查询权限
					SHOW GRANTS FOR '用户名'@'主机名';
					SHOW GRANTS FOR 'lisi'@'%';
					
					-- 给李四用户授予所有权限，在任意数据库和任意表
					grant ALL on *.* to 'lisi'@'%';
				2、授予权限
					-- 授予权限
					grant 权限列表 on 数据库名.表名 to '用户名'@'主机名'；
					
				3、撤销权限
					-- 撤销权限
					revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名'；
					
				
	 
	 	
	 	
 	
	
	
	
	
	
	
	
			
		
