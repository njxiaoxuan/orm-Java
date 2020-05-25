package com.jason.daosupport;

import com.jason.bean.Blog;
import com.jason.dao.BlogMapper;
import org.springframework.stereotype.Repository;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 11:41
 **/
@Repository
public class BlogDaoImpl extends BaseDao implements BlogMapper {
    @Override
    public Blog selectByPrimaryKey(Integer bid) {
        Blog blog= (Blog) this.selectOne("com.jason.dao.BlogMapper.selectByPrimaryKey",bid);
        return blog;
    }

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return 0;
    }

    @Override
    public int insert(Blog record) {
        return 0;
    }

    @Override
    public int insertSelective(Blog record) {
        return 0;
    }



    @Override
    public int updateByPrimaryKeySelective(Blog record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        return 0;
    }
}
