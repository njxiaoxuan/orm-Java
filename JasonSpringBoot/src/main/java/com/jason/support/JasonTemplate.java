package com.jason.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;

import java.util.List;
import java.util.Map;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-23 15:35
 **/
public class JasonTemplate {
    public static void main(String[] args) {

    }
    public static String MapToJason(Map map)
    {
        if(map==null)
        {
            System.out.println("imput map is null");
            return null;
        }
        return JSON.toJSONString(map);
    }
    public static String ListToJason(List map)
    {
        if(map==null)
        {
            System.out.println("imput map is null");
            return null;
        }
        return JSON.toJSONString(map);
    }
}
