package com.shawn.repository;

import com.shawn.model.entity.Book;
import com.shawn.model.entity.BookWithBookStore;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookRepository {

    Book selectBookById(Long id);

    List<Book> selectBooksByAuthor(String author);

    List<Book> selectBooksByLowPriceAndHighPrice(Double lowPrice, Double highPrice);

    List<Book> selectAllBooks();

    List<Book> selectBooksByPage(Integer offset, Integer perPage);

    BookWithBookStore selectBookWithBookStoreById(Long id);

    Integer selectCount();

    Integer insertBook(Book book);

    Integer updateBookOnNameById(Book book);

    Integer deleteBookById(Long id);

}
