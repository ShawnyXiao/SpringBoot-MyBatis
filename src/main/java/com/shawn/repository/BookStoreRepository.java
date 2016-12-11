package com.shawn.repository;

import com.shawn.model.entity.BookStore;
import com.shawn.model.entity.BookStoreWithBooks;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
