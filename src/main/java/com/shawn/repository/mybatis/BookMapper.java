package com.shawn.repository.mybatis;

import com.shawn.model.Book;
import com.shawn.repository.BookRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
@Mapper
public interface BookMapper extends BookRepository {

    @Override
    List<Book> selectBooksByLowPriceAndHighPrice(@Param("lowPrice") double lowPrice, @Param("highPrice") double highPrice);

}
