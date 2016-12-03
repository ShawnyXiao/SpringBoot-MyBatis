package com.shawn.repository;

import com.shawn.model.Book;
import com.shawn.model.BookWithBookStore;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookRepository {

    Book selectBookById(Long id);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(Double lowPrice, Double highPrice);

    List<Book> selectAllBooks();

    BookWithBookStore selectBookWithBookStoreById(Long id);

    int insertBook(Book book);

    int updateBookOnNameById(Book book);

    int deleteBookById(Long id);

}
