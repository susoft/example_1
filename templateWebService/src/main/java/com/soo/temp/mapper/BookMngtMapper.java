package com.soo.temp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soo.temp.vo.Book;

@Mapper
public interface BookMngtMapper {
	List<Book> selectAll();
}
