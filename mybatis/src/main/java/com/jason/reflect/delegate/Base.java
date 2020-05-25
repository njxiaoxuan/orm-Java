package com.jason.reflect.delegate;

import java.util.List;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 23:47
 **/
public interface Base<T> {
       List<T> query(T t);
       int update(T t);
       int delete(T t);
       int add(T t);
}
