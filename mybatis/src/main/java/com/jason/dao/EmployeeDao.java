package com.jason.dao;

import com.jason.bean.Employee;

import java.util.List;


/**
 * @program: mybatis
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-06 23:45
 **/
public interface EmployeeDao {
    Employee findById();
    int addEmployee(Employee employee);
    int addBatchEmployee(List<Employee> employeeList);
    int updateById(Employee employee);
    int deleteById(Employee employee);

}
