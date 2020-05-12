package com.jason.support;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 22:12
 **/
public class MybatisTemplate {
    private static Object lock=new Object();
    private static SqlSessionFactory sqlMapper=null;
    private static ThreadLocal<SqlSession>  local=new ThreadLocal<SqlSession>();
    static{
        Reader reader=null;
        try {
            String resources = "mybatis.xml";
            //读取mybatis-config.xml文件到reader对象中
            reader= Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis,创建SqlSessionFactory类的实例
        sqlMapper=new SqlSessionFactoryBuilder().build(reader);
    }

    public static  SqlSession  getSession()
    {
            if(local.get()!=null)
            {
                 return local.get();
            }
            synchronized (lock)
            {
                if (local.get()==null)
                {
                    local.set(sqlMapper.openSession());
                }
            }
            return local.get();
    }

}
