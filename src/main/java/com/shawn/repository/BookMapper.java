package com.shawn.repository;

import com.shawn.model.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xiaoyue Xiao
 */
@Mapper
public interface BookMapper {

    Book selectBookById(long bookId);

//    List<Book> selectBooksByAuthor(@Param("author") String author);
//
//    List<Book> selectAllBooks();
//
//    void insertBook(Book book);
//
//    void updateBook(Book book);
//
//    void deleteBookById(@Param("id") long id);

}
