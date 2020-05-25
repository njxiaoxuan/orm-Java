package com.jason.reflect.cglib;

import com.jason.reflect.Student;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-16 10:53
 **/
public class CglibObjectFactory<T> {

    public static <T> T getProxyInstance(Class<T> clazz) {
        Enhancer en = new Enhancer();
        // set target proxy
        en.setSuperclass(clazz);
        // set proxy interceptor
        en.setCallback(new CglibAroundAdvice());
        // create proxy instance
        T o = (T)en.create();
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "R:\\a.class");
        return o;//class com.jason.reflect.cglib.Student$$EnhancerByCGLIB$$5bca626a
    }

    public static void main(String[] args) {
           Student student=CglibObjectFactory.getProxyInstance(Student.class);
           student.getName();
           student.testCglib("helloword!");
    }
}
