package com.itheima.mybatis.utils;

import com.itheima.mybatis.cfg.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class Executor {
    public <E> ArrayList<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // 1、取出mapper中的数据
            String queryString = mapper.getQueryString();// select * from user
            String resultType = mapper.getResultType();// com.itheima.domain.User
            Class domainClass = Class.forName(resultType);
            // 2、获取PreparedStatement对象
            pstm = conn.prepareStatement(queryString);
            // 3、执行SQL语句，获取结果集
            rs = pstm.executeQuery();
            // 4、封装结果集
            ArrayList<E> list = new ArrayList<E>();// 定义返回值
            while (rs.next()) {
                // 实例化要封装的实体类对象
                E obj = (E) domainClass.newInstance();
                // 取出结果集的元信息：ResultSetMetaData
                ResultSetMetaData rsmd = rs.getMetaData();
                // 取出总列数
                int columnCount = rsmd.getColumnCount();
                // 遍历总列数
                for (int i = 1; i <= columnCount; i++) {
                    // 获取每列的名称，列名的需要是从1开始的
                    String columnName = rsmd.getColumnName(i);
                    // 更具得到列明，获取每列的值
                    Object columnValue = rs.getObject(columnName);
                    // 给obj赋值：使用java内省机制(借助PropertyDescriptor实现属性的封装)
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, domainClass);// 要求
                    // 获取他的写入方法
                    Method writeMethod = pd.getWriteMethod();
                    // 把获取的列的值，给对象赋值
                    writeMethod.invoke(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
         throw new RuntimeException(e);
        }finally {
            release(pstm,rs);
        }
    }

    private void release(PreparedStatement pstm, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (pstm != null){
            try {
                pstm.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
