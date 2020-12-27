package com.offcn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    static SqlSessionFactory sqlSessionFactory;
    static {
        //1创建总配置文件的输入流对象
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            //2创建SqlSessionFatory对象，相当于JDBC中的DriverManager
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
    public static void close(SqlSession session){
        if (session!=null)session.close();;
    }

}
