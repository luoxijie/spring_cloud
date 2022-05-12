package com.qianfeng.customerui.feign;


import com.qianfeng.goodscommons.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="customer-provider", fallback = CustomerUIFeignImpl.class)
public interface CustomerUIFeign {

    @GetMapping("/customer/list")
    List<Customer> getList();

    @GetMapping("/customer/detail")
    Customer getDetail(@RequestParam("id") Integer id);

}
