package com.jason.bean.associate;

import com.jason.bean.SellInfo;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-11 22:12
 **/
@Alias("businessAndSellInfo")
public class BusinessAndSellInfo
{
    private long id;
    private String name;
    private Date addTime;
    private String remark;
    private Set<SellInfo> sellInfo=new HashSet<SellInfo>();

    public Set<SellInfo> getSellInfo() {
        return sellInfo;
    }

    public void setSellInfo(Set<SellInfo> sellInfo) {
        this.sellInfo = sellInfo;
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
                ", sellInfoList=" + sellInfo.toString() +
                '}';
    }
}
