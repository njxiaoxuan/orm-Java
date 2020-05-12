package com.jason.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 23:13
 **/
@Alias("business")
public class Business  implements Serializable {
    private long id;
    private String name;
    private Date  addTime;
    private String remark;
    private Set<String> sellInfoList=new HashSet<String>();

    public Set<String> getSellInfoList() {
        return sellInfoList;
    }

    public void setSellInfoList(Set<String> sellInfoList) {
        this.sellInfoList = sellInfoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime=" + addTime +
                ", remark='" + remark + '\'' +
                ", sellInfoList=" + sellInfoList.toString() +
                '}';
    }
}
