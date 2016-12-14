package com.shawn.web.controller;

import com.shawn.constant.PageConstant;
import com.shawn.constant.ResourceNameConstant;
import com.shawn.model.dto.PaginatedResult;
import com.shawn.model.dto.Result;
import com.shawn.model.entity.Book;
import com.shawn.service.BookService;
import com.shawn.util.PageUtil;
import com.shawn.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Xiaoyue Xiao
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "perPage", required = false) String perPageString) {
        // Parse request parameters
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setStatus(HttpStatus.OK.value())
                        .setData(bookService.getBooksByPage(page, perPage))
                        .setCurrentPage(page)
                        .setTotalPage(bookService.getTotalPage(perPage)));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        return bookService
                .getBookById(bookId)
                .map(book -> ResponseEntity
                        .ok(new Result()
                                .setStatus(HttpStatus.OK.value())
                                .setData(book)))
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(ResourceNameConstant.BOOK)
                        .setId(bookId));
    }

    @PostMapping
    public ResponseEntity<?> postBook(@RequestBody Book book) {
        boolean result = bookService.saveBook(book);

        if (!result) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Result()
                            .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Creating book is failed."));
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(book.getId())
                    .toUri();
            return ResponseEntity
                    .created(location)
                    .body(new Result()
                            .setStatus(HttpStatus.CREATED.value())
                            .setMessage("The book is created.")
                            .setData(book));
        }
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> putBook(@PathVariable Long bookId, @RequestBody Book book) {
        assertBookExist(bookId);

        boolean result = bookService.modifyBookOnNameById(book.setId(bookId));

        if (!result) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Result()
                            .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Modifying book with id " + bookId + " is failed."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Result()
                            .setStatus(HttpStatus.OK.value())
                            .setMessage("The book with id " + bookId + " is modified."));
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        assertBookExist(bookId);

        boolean result = bookService.deleteBookById(bookId);

        if (!result) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Result()
                            .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Deleting book with id " + bookId + " is failed.")
                    );
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Result()
                            .setStatus(HttpStatus.OK.value())
                            .setMessage("The book with id " + bookId + " is deleted."));
        }
    }

    /********************************** HELPER METHOD **********************************/
    private void assertBookExist(Long bookId) {
        bookService
                .getBookById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(ResourceNameConstant.BOOK)
                        .setId(bookId));
    }

}
