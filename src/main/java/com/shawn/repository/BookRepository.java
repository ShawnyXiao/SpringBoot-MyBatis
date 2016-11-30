package com.shawn.repository;

import com.shawn.model.Book;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookRepository {

    Book selectBookById(long bookId);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(double lowPrice, double highPrice);

    List<Book> selectAllBooks();

    int insertBook(Book book);

    int updateBookOnNameById(Book book);

    int deleteBookById(long bookId);

}
