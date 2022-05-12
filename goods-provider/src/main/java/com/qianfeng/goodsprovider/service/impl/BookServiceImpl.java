package com.qianfeng.goodsprovider.service.impl;

import com.qianfeng.goodscommons.pojo.Book;
import com.qianfeng.goodsprovider.dao.BookDao;
import com.qianfeng.goodsprovider.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2022-05-10 15:22:04
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(Integer bookId) {
        return this.bookDao.queryById(bookId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Book> queryAllByLimit(int offset, int limit) {
        return this.bookDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book insert(Book book) {
        this.bookDao.insert(book);
        return book;
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        this.bookDao.update(book);
        return this.queryById(book.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bookId) {
        return this.bookDao.deleteById(bookId) > 0;
    }

    @Override
    public List<Book> getBooksList() {
        return this.bookDao.getBooksList();
    }

    @Override
    public Book getDetail(Integer id) {
        return this.bookDao.queryById(id);
    }

    @Override
    public String addBook(Book book) {
        int i = this.bookDao.insert(book);
        return i != 0 ? "success" : "fail";
    }
}
