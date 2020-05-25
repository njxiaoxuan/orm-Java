package com.jason.main;
import com.alibaba.fastjson.JSON;
import com.jason.bean.Employee;
import com.jason.support.MybatisTemplate;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-07 00:05
 **/
public class MyTest {

    public static void main(String[] args) {

        //1、创建session实例
        SqlSession session= MybatisTemplate.getSession();

        //2、传入参数查询，返回结果
        System.out.println("1、查询测试：");
        Employee user=session.selectOne("findById",1);
        if (user!=null)
        {
            System.out.println(user.getName());
        }
        int nRet=0;
        System.out.println("2、插入测试：");
//        Employee  employee=new Employee();
//        employee.setAge(30);
//        employee.setName("jerry");
//        nRet=session.insert("addEmployee",employee);
//        session.commit();
//        System.out.println("nRet="+nRet);

//        System.out.println("3、更新测试：");
//        Employee  employee=new Employee();
//        employee.setId(1);
//        nRet=session.update("updateById",employee);
//        session.commit();
//        System.out.println("nRet="+nRet);

        System.out.println("4、批量插入测试：");
        List<Employee> employeeList=new ArrayList<Employee>();

        Employee  employee1=new Employee();
        employee1.setAge(12);
        employee1.setName("tom");
        employeeList.add(employee1);

        Employee  employee2=new Employee();
        employee2.setAge(11);
        employee2.setName("jiahongfei");
        employeeList.add(employee2);
        System.out.println(JSON.toJSON(employeeList));
        nRet=session.insert("addBatchEmployee",employeeList);
        session.commit();
        System.out.println("nRet="+nRet);

        System.out.println("5、条件删除：");
        Employee  employee3=new Employee();
        employee3.setId(31);
        employee3.setName("tom");
        nRet=session.delete("deleteById",employee3);
        session.commit();
        System.out.println("成功删除记录数："+nRet);
        //关闭session
        session.close();
    }
}
