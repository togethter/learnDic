package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {
    // 引用类型，在xml文件给属性赋值，要求属性需要有set方法
    // byType
    @Autowired
    @Qualifier("mysqlDao")
    private UserDao dao = null;
    // 可以不需要
    public void setDao(UserDao dao) {this.dao=dao;}
    @Override
    public void addUser(SysUser user){
        // 处理数据，调用dao方法
        // 调用dao的方法
        dao.insertUser(user);
    }
}
