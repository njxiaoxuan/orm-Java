package com.jason.reflect.proxy;

import java.util.ResourceBundle;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:19
 **/
public class JasonSqlSession {
        JasonConfiguration  configuration;
        JasonExecutor executor=new JasonExecutor();

    public JasonSqlSession(JasonConfiguration configuration) {
        this.configuration = configuration;
    }
    public JasonConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public <T> T selectOne(String sid, Object param)
        {
            String sql=JasonConfiguration.mapperNamespace.get(sid);
            return executor.query(sql,param);
        }
        public <T> T getMapper(Class clzz)
        {
            return configuration.getMapper(clzz,this);
        }
}
