package com.itheima.mybatis.SqlSession.defaults;
import com.itheima.mybatis.SqlSession.SqlSession;
import com.itheima.mybatis.SqlSession.SqlSessionFactory;
import com.itheima.mybatis.cfg.Configuration;

/**
 * SqlSessioFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
