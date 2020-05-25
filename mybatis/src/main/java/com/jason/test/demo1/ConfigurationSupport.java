package com.jason.test.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-16 23:27
 **/
public class ConfigurationSupport {
       public static Map<String, HashMap<String,String>> ioc=new HashMap<String,HashMap<String,String>>();

       static{
           HashMap<String,String> hashMap=new HashMap<String,String>();
           hashMap.put("name","root");
           hashMap.put("password","root");
           hashMap.put("url","http://localhost:3306/OCS");
           hashMap.put("driver","orm.mysql.com");
           ioc.put("mysql",hashMap);
       }
}
