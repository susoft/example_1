package com.soo.temp.vo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    private String title;
    private String author;
    
    protected Book() {}
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', author='%s']", id, title, author);
    }
}
