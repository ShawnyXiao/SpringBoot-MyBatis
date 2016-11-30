package com.shawn.service;

import com.shawn.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiaoyue Xiao
 */
public interface BookService {

    Optional<Book> getBookById(long bookId);

    List<Book> getBooksByAuthor(String author);

    List<String> getAllBookNames();

    boolean saveBook(Book book);

    boolean updateBookOnNameById(Book book);
}
