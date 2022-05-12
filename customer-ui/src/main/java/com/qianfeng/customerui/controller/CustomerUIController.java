package com.qianfeng.customerui.controller;

import com.qianfeng.customerui.feign.CustomerUIFeign;
import com.qianfeng.goodscommons.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/customer")
@ResponseBody
public class CustomerUIController {

    @Resource
    private CustomerUIFeign customerUIFeign;

    @RequestMapping("/list")
    public List<Customer> list(){
        return this.customerUIFeign.getList();
    }

    @RequestMapping("/detail/{id}")
    public Customer detail(@PathVariable("id") Integer id){
        return this.customerUIFeign.getDetail(id);
    }

}
