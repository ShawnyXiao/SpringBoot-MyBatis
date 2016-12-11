package com.shawn.service;

import com.shawn.model.entity.BookStore;
import com.shawn.model.entity.BookStoreWithBooks;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiaoyue Xiao
 */
public interface BookStoreService {

    Optional<BookStore> getBookStoreById(Long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id);

}
