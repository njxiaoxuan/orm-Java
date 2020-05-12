package com.jason.service;

import com.alibaba.fastjson.JSONArray;
import com.jason.bean.Business;
import com.jason.bean.SellInfo;
import com.jason.bean.associate.BusinessAndSellInfo;
import com.jason.support.MybatisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;




/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 23:38
 **/
public class BusinessService {
       public static int register(Business business)
       {
           int nRet=0;
           SqlSession  sqlSession=MybatisTemplate.getSession();
           nRet=sqlSession.insert("addBusiness",business);

           List<SellInfo> infoList=new ArrayList<SellInfo>();
           String str_selltype=handlerSellListToStr(business.getSellInfoList());
           SellInfo info=new SellInfo();
           info.setBusinessid(business.getId());
           info.setSellinfo(str_selltype);
           infoList.add(info);
           sqlSession.insert("addSellInfo",info);
           sqlSession.commit();

           return nRet ;
       }
       public static int update(Business business)
       {
            int nRet=0;
            SqlSession  sqlSession=MybatisTemplate.getSession();
            System.out.println("sqlSession=============="+sqlSession);
            nRet=sqlSession.update("update",business);
            sqlSession.commit();
            sqlSession.commit();
            return nRet;
       }

    private static String handlerSellListToStr(Set<String> sellInfoList) {
       if(sellInfoList==null||sellInfoList.size()==0)
       {
           return null;
       }
        return StringUtils.join(sellInfoList.toArray(),",");
    }
    private static Set<String> handlerSellStrToSet(String sellInfostr) {
        if(sellInfostr==null||sellInfostr.length()==0)
        {
            return null;
        }
        return new HashSet<String>(Arrays.asList(sellInfostr.split(",")));
    }

    //用于测试构造对象使用
    private static Business getBusiness()
    {
        Business  business=new Business();
        business.setName("店小二Jason");
        Set<String> sellkindlist=new HashSet<String>();
        sellkindlist.add("1");
        sellkindlist.add("2");
        sellkindlist.add("3");
        sellkindlist.add("4");
        business.setSellInfoList(sellkindlist);

        try {
            business.setAddTime(BusinessService.getSystemDate());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        business.setRemark("小贾电子产品销售旗舰店");

        return  business;
    }

    @Test
    public static Business queryBusinessInfoById(long id) {
        Business business=new Business();
        business.setId(id);
        SqlSession  sqlSession=MybatisTemplate.getSession();
        System.out.println("sqlSession=============="+sqlSession);
        Business business1=sqlSession.selectOne("selectBusinessById",business);
        SellInfo  info=sqlSession.selectOne("selectSellInfoByBid",business.getId());
        System.out.println(info.toString());
        business1.setSellInfoList(BusinessService.handlerSellStrToSet(info.getSellinfo()));
        return business1;
    }
    @Test
    public static List<BusinessAndSellInfo> selectBusinessWithSellInfo() {

        SqlSession  sqlSession=MybatisTemplate.getSession();
        System.out.println("sqlSession=============="+sqlSession);

        List<BusinessAndSellInfo>    bussinessAndSellInfoList=sqlSession.selectList("selectBusinessWithSellInfo");
        return bussinessAndSellInfoList;
    }
    @Test
    public static Date   getSystemDate() throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr);
        Date date2 = simpleDateFormat.parse(dateStr);

        return  date2;
    }
    public static void main(String[] args) {
//        //模拟构造对象
//        Business business=BusinessService.getBusiness();
//        //注册
//        BusinessService.register(business);
//        System.out.println("-----------------------"+business.getId());
        //******************************************查询*******************************
//        System.out.println("执行第一次查询：");
//        Business  business1=null;
//        business1=queryBusinessInfoById(6l);
//        System.out.println(business1.toString());
//
//        final  Business business=new Business();
//        business.setId(business1.getId());
//        business.setName("终极挑战......");
//        Thread thread1=new Thread(){
//            @Override
//            public void run() {
//                System.out.println("启动线程，执行更新操作");
//                update(business);
//            }
//        };
//        thread1.start();
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread thread2=new Thread(){
//            @Override
//            public void run() {
//                System.out.println("启动线程，执行更新操作");
//                System.out.println("执行第二次查询：");
//                Business  business3=queryBusinessInfoById(6l);
//                System.out.println(business3.toString());
//            }
//        };
//        thread2.start();


        Thread thread3=new Thread(){
            @Override
            public void run() {
                System.out.println("启动线程，执行更新操作");
               List<BusinessAndSellInfo>  businessAndSellInfoList =selectBusinessWithSellInfo();
                System.out.println(businessAndSellInfoList.toString());
            }
        };
        thread3.start();






    }
}
