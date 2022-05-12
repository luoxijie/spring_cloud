package com.qianfeng.goodscommons.pojo;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2022-05-10 16:48:04
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -42402406517907687L;

    private Integer id;

    private String customerName;

    private String customerAddress;

    private String customerTicket;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTicket() {
        return customerTicket;
    }

    public void setCustomerTicket(String customerTicket) {
        this.customerTicket = customerTicket;
    }

}
