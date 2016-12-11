package com.shawn.service.impl;

import com.shawn.model.entity.BookStore;
import com.shawn.model.entity.BookStoreWithBooks;
import com.shawn.repository.BookStoreRepository;
import com.shawn.service.BookStoreService;
import com.shawn.web.exception.ServiceException;
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
@Service("BookStoreService")
public class BookStoreServiceImpl implements BookStoreService {

    private BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public Optional<BookStore> getBookStoreById(Long id) {
        Optional<BookStore> result = Optional.empty();
        try {
            result = Optional.ofNullable(bookStoreRepository.selectBookStoreById(id));
        } catch (Exception e) {
            log.error("[BookStoreServiceImpl][getBookStoreById()][id=" + id + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public List<String> getAllBookStoreNames() {
        List<String> result = new ArrayList<>();
        try {
            result = bookStoreRepository.selectAllBookStores()
                    .stream()
                    .map(BookStore::getName)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("[BookStoreServiceImpl][getAllBookStoreNames()][]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }

    @Override
    public Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id) {
        Optional<BookStoreWithBooks> result = Optional.empty();
        try {
            result = Optional.ofNullable(bookStoreRepository.selectBookStoreWithBooksById(id));
        } catch (Exception e) {
            log.error("[BookStoreServiceImpl][getBookStoreWithBooksById()][id=" + id + "]: A problem occurred!", e);
            throw new ServiceException("Something wrong occurred on service layer of server, please contact administrator", e);
        }
        return result;
    }
}
