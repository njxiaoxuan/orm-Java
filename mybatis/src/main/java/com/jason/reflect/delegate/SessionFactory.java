package com.jason.reflect.delegate;

import java.util.List;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-14 23:51
 **/
public class SessionFactory<T>  implements Base<T>{
    @Override
    public List query(T o) {
        System.out.println("null");
        return null;
    }

    @Override
    public int update(T o) {
        return 0;
    }

    @Override
    public int delete(T o) {
        return 0;
    }

    @Override
    public int add(T o) {
        return 0;
    }


}
