package com.jason.reflect.proxy;

import com.jason.reflect.Student;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 21:54
 **/
public interface StudentMapper {
       Student queryStudentById(String id);
}
