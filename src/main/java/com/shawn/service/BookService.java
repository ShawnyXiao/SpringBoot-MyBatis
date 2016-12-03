package com.shawn.service;

import com.shawn.model.Book;
import com.shawn.model.BookWithBookStore;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiaoyue Xiao
 */
public interface BookService {

    Optional<Book> getBookById(Long id);

    List<Book> getBooksByAuthor(String author);

    List<String> getAllBookNames();

    Optional<BookWithBookStore> getBookWithBookStoreById(Long id);

    boolean saveBook(Book book);

    boolean updateBookOnNameById(Book book);
}
