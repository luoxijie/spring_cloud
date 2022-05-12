package com.qianfeng.goodsui.controller;

import com.qianfeng.goodscommons.pojo.Book;
import com.qianfeng.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/goods-ui")
public class GoodsUIController {

    @Resource
    private GoodsUIService goodsUIService;

//  测试
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        goodsUIService.testGoodsProvider();
        return "success";
    }

//  查询所有图书
    @RequestMapping("/list")
    @ResponseBody
    public List<Book> getList(){
        return goodsUIService.getList();
    }

//  图书详情
    @RequestMapping("/detail/{id}")
    @ResponseBody
    public Book detail(@PathVariable("id")Integer id){
        return this.goodsUIService.getDetail(id);
    }

//  添加图书
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        return this.goodsUIService.add(book);
    }

}
