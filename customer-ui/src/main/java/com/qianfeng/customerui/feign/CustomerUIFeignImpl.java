package com.qianfeng.customerui.feign;

import com.qianfeng.goodscommons.pojo.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign {
    @Override
    public List<Customer> getList() {
        return null;
    }

    @Override
    public Customer getDetail(Integer id) {
        System.out.println("服务降级反应");
        return new Customer();
    }
}
