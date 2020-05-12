package com.gupaoedu.service;

import com.gupaoedu.dao.BlogDao;
import com.gupaoedu.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogDao blogDao;


    public List<Blog> queryBlog()
    {
        return blogDao.findAll();
    }

    public void addBlog(Blog blog)
    {
        blogDao.save(blog);
    }
}
