package com.shawn.repository;

import com.shawn.model.Book;
import com.shawn.model.BookWithBookStore;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookRepository {

    Book selectBookById(long id);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(double lowPrice, double highPrice);

    List<Book> selectAllBooks();

    BookWithBookStore selectBookWithBookStoreById(long id);

    int insertBook(Book book);

    int updateBookOnNameById(Book book);

    int deleteBookById(long id);

}
