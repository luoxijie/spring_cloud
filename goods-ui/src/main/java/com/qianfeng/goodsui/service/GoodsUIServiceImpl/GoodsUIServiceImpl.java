package com.qianfeng.goodsui.service.GoodsUIServiceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qianfeng.goodscommons.pojo.Book;
import com.qianfeng.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUIServiceImpl implements GoodsUIService{

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        // 应用名称和对应的映射url组合
        String obj =  restTemplate.getForObject("http://goods-provider/book/test", String.class);
        System.out.println(obj);
    }

    @Override
    public List<Book> getList() {
        Book[] list = restTemplate.getForObject("http://goods-provider/book/list", Book[].class);
        return Arrays.asList(list);
    }

    @HystrixCommand(
    fallbackMethod = "fallback_getBook",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1000")}//降级响应设置超时时间(比如我这里设置1000毫秒之内拿不到对应的响应，直接返回降级响应)
    )
    @Override
    public Book getDetail(Integer id) {
        Book book = restTemplate.getForObject("http://goods-provider/book/detail/" + id, Book.class);
        return book;
    }
    public Book fallback_getBook(Integer id){
        // 降级响应，返回为空
        System.out.println("降级响应，返回为空");
        return new Book();
    }

    @Override
    public String add(Book book) {
        String msg = restTemplate.postForObject("http://goods-provider/book/add", book, String.class);
        return msg;
    }

}
