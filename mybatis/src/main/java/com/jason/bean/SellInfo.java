package com.jason.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 23:13
 **/
@Alias("sellInfo")
public class SellInfo  implements Serializable {
    private long id;
    private long businessid;
    private String sellinfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessid() {
        return businessid;
    }

    public void setBusinessid(long businessid) {
        this.businessid = businessid;
    }

    public String getSellinfo() {
        return sellinfo;
    }

    public void setSellinfo(String sellinfo) {
        this.sellinfo = sellinfo;
    }

    @Override
    public String toString() {
        return "SellInfo{" +
                "id=" + id +
                ", businessid=" + businessid +
                ", sellinfo='" + sellinfo + '\'' +
                '}';
    }
}
