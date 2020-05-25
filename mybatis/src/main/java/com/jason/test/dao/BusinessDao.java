package com.jason.dao;

import com.jason.bean.Business;
import com.jason.bean.associate.BusinessAndSellInfo;

import java.util.List;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 23:19
 **/
public interface BusinessDao {
     public  int addBusiness(Business business);
     public  Business selectBusinessById(Business  business);
     public  int update(Business  business);
     public List<BusinessAndSellInfo> selectBusinessWithSellInfo();

}
