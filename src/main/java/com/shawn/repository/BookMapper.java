package com.shawn.repository;

import com.shawn.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
@Mapper
public interface BookMapper {

    Book selectBookById(long bookId);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(@Param("lowPrice") double lowPrice, @Param("highPrice") double highPrice);

    List<Book> selectAllBooks();

    void insertBook(Book book);

    void updateBookOnNameById(Book book);

    void deleteBookById(long id);

}
