package com.shawn.service.impl;

import com.shawn.model.Book;
import com.shawn.model.BookWithBookStore;
import com.shawn.repository.BookRepository;
import com.shawn.service.BookService;
import com.shawn.web.exception.ServiceException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<Book> getBookById(Long id) {
        Optional<Book> result = Optional.empty();
        try {
            result = Optional.ofNullable(bookRepository.selectBookById(id));
        } catch (Exception e) {
            log.error("[BookServiceImpl][getBookById()][id=" + id + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        try {
            result = bookRepository.selectBooksByAuthor(author);
        } catch (Exception e) {
            log.error("[BookServiceImpl][getBooksByAuthor()][author=" + author + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        try {
            result = bookRepository.selectAllBooks();
        } catch (Exception e) {
            log.error("[BookServiceImpl][getAllBooks()][]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public List<String> getAllBookNames() {
        List<String> result = new ArrayList<>();
        try {
            result = bookRepository
                    .selectAllBooks()
                    .stream()
                    .map(Book::getName)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("[BookServiceImpl][getAllBookNames()][]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public Optional<BookWithBookStore> getBookWithBookStoreById(Long id) {
        Optional<BookWithBookStore> result = Optional.empty();
        try {
            result = Optional.ofNullable(bookRepository.selectBookWithBookStoreById(id));
        } catch (Exception e) {
            log.error("[BookServiceImpl][getBookWithBookStoreById()][id=" + id + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    @Transactional
    public boolean saveBook(Book book) {
        boolean result = false;
        try {
            result = bookRepository.insertBook(book) > 0;
        } catch (Exception e) {
            log.error("[BookServiceImpl][saveBook(Book)][book=" + book + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    @Transactional
    public boolean updateBookOnNameById(Book book) {
        boolean result = false;
        try {
            result = bookRepository.updateBookOnNameById(book) > 0;
        } catch (Exception e) {
            log.error("[BookServiceImpl][updateBookOnNameById(Book)][book=" + book + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }
}
