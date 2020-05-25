package com.jason.control;

import com.jason.bean.Blog;
import com.jason.bean.ResponseMessage;
import com.jason.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 11:59
 **/
//@Controller
@RestController
public class BlogControl {
    @Autowired
    public BlogService  blogService;

    //根据id查询员工
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage geEmp(@PathVariable("id") Integer id) {
        Blog employee = blogService.getEmp(id);
        return ResponseMessage.success().add("emp", employee);
    }

}
