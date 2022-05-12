package com.qianfeng.customerprovider.controller;

import com.qianfeng.customerprovider.service.CustomerService;
import com.qianfeng.goodscommons.pojo.Customer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2022-05-10 16:48:06
 */
@RestController
@RequestMapping("customer")
@ResponseBody
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Customer selectOne(Integer id) {
        return this.customerService.queryById(id);
    }

    @RequestMapping("/list")
    public List<Customer> getList(){
        return this.customerService.getCustomerList();
    }

    @RequestMapping("/detail")
    public Customer detail(@RequestParam("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.customerService.queryById(id);
    }

}
