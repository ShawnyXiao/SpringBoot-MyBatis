package com.shawn.repository;

import com.shawn.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xiaoyue Xiao
 */
@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(@Param("id") long id);

}
