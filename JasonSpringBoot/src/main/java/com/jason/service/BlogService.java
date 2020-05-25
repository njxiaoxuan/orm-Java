package com.jason.service;

import com.jason.bean.Blog;
import com.jason.dao.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 11:47
 **/
@Service
public class BlogService {

    @Autowired
    public BlogMapper  blogMapper;
    //按id查询
    public Blog getEmp(Integer id) {
        Blog employee = blogMapper.selectByPrimaryKey(id);
        return employee;
    }
}
