package com.jason.dao;

import com.jason.bean.Business;
import com.jason.bean.SellInfo;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 23:19
 **/
public interface SellInfoDao {
    int addSellInfo(SellInfo sellInfo);
    SellInfo selectSellInfoByBid(long  bId);
}
