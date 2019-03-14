package com.soo.temp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soo.temp.repo.BookRepository;
import com.soo.temp.service.BookMngtService;
import com.soo.temp.vo.Book;

@RestController
@EnableAutoConfiguration
public class BookController {
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
    private BookMngtService bookMngtService;
 
	@RequestMapping("/getlist")
    public List<Book> getlist() {
        return bookRepository.findAll();
    }
	
	@RequestMapping("/getlistByMybatis")
    public List<Book> getlistByMybatis() {
        return bookMngtService.getAll();
    }
	
	
	
	
	
    @GetMapping("getAll")
    public  List<Book> findAll() {
        return bookRepository.findAll();
    }
 
    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }
 
    @GetMapping("/{id}")
    public Optional<Book> findOne(@PathVariable Long id) {
        return bookRepository.findById(id);
    }
    
    @GetMapping("save")
    public List<Book> save() {
    	bookRepository.save(new Book("Jack", "Bauer"));
    	bookRepository.save(new Book("Chloe", "O'Brian"));
    	bookRepository.save(new Book("Kim", "Bauer"));
    	bookRepository.save(new Book("David", "Palmer"));
		bookRepository.save(new Book("Michelle", "Dessler"));
		
		return bookRepository.findAll();
    }
}
