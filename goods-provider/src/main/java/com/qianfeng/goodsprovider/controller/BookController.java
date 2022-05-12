package com.qianfeng.goodsprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qianfeng.goodscommons.pojo.Book;
import com.qianfeng.goodsprovider.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2022-05-10 15:22:05
 */
@RestController
@RequestMapping("/book")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Book selectOne(Integer id) {
        return this.bookService.queryById(id);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Book> getList(){
        return this.bookService.getBooksList();
    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    public Book detail(@PathVariable("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.bookService.getDetail(id);
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    /** 用来测试服务熔断机制*/
    //服务熔断配置
    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//服务错误率
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num") Integer num){
        int n = (int) Math.floor(Math.random()*100);
        int result = n / num;
        return "服务正常返回:"+ n +"/"+ num +"="+result;
    }
    public String fallBack(@RequestParam("num") Integer num){
        System.out.println("开启服务熔断");
        return "服务降级响应:num为0";
    }

}
