package com.bob.stu.mybatis.mybatis;

import com.bob.stu.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis测试
 *
 * @author bob tel:15811588260
 * @version 1.0
 * @since 2016/12/3
 */
public class MybatisTest {

    private final static Logger _log = Logger.getLogger(MybatisTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            //通过输入流来加载核心配置文件SqlMapConfig.xml
            InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
            //通过加载核心配置文件中的内容，创建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过会话工厂创建会话
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            _log.error("创建会话失败");
            return;
        }
        //第一个参数：调用的sql语句=namespace+.+sql语句的id
        User user = sqlSession.selectOne("com.bob.stu.mybatis.po.User.findUserById", 1);
        _log.info(user);
        sqlSession.close();

    }
}
