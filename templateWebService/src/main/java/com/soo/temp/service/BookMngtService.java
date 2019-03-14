package com.soo.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soo.temp.mapper.BookMngtMapper;
import com.soo.temp.vo.Book;

@Service
@Transactional
public class BookMngtService {
	@Autowired
	BookMngtMapper bookMngtMapper;
	
	public List<Book> getAll() {
        return bookMngtMapper.selectAll();
    }
}
