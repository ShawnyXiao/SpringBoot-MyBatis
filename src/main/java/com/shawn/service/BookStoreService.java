package com.shawn.service;

import com.shawn.model.BookStore;
import com.shawn.model.BookStoreWithBooks;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiaoyue Xiao
 */
public interface BookStoreService {

    Optional<BookStore> getBookStoreById(long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(long id);

}
