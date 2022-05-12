package com.qianfeng.goodscommons.pojo;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2022-05-10 15:21:54
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -58018741557545046L;

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookDesc;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

}
