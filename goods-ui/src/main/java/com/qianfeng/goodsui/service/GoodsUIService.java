package com.qianfeng.goodsui.service;


import com.qianfeng.goodscommons.pojo.Book;

import java.util.List;

public interface GoodsUIService {

    void testGoodsProvider();

    List<Book> getList();

    Book getDetail(Integer id);

    String add(Book book);
}
