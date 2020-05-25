package com.jason.dao;

import com.jason.bean.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface BlogMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}