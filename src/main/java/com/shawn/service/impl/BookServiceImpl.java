package com.shawn.service.impl;

import com.shawn.model.Book;
import com.shawn.repository.BookRepository;
import com.shawn.service.BookService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Xiaoyue Xiao
 */
@CommonsLog
@Service("BookService")
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBookById(long bookId) {
        return Optional.ofNullable(bookRepository.selectBookById(bookId));
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.selectBooksByAuthor(author);
    }

    @Override
    public List<String> getAllBookNames() {
        List<String> result = new ArrayList<>();
        try {
            result = bookRepository.selectAllBooks().stream()
                    .map(Book::getName)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("[BookServiceImpl][getAllBookNames()][]: A problem occurred!", e);
        }
        return result;
    }

    @Override
    public boolean saveBook(Book book) {
        boolean result = false;
        try {
            result = bookRepository.insertBook(book) > 0;
        } catch (Exception e) {
            log.error("[BookServiceImpl][saveBook(Book)][book=" + book + "]: A problem occurred!", e);
        }
        return result;
    }

    @Override
    public boolean updateBookOnNameById(Book book) {
        boolean result = false;
        try {
            result = bookRepository.updateBookOnNameById(book) > 0;
        } catch (Exception e) {
            log.error("[BookServiceImpl][updateBookOnNameById(Book)][book=" + book + "]: A problem occurred!", e);
        }
        return result;
    }
}
