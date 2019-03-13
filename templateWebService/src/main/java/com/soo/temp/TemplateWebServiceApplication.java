package com.soo.temp;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.soo.temp.repo.BookRepository;
import com.soo.temp.vo.Book;

@SpringBootApplication
@MapperScan(basePackages = "com.soo.temp.map")
public class TemplateWebServiceApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(TemplateWebServiceApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(TemplateWebServiceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TemplateWebServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// save a couple of Books
			repository.save(new Book("Jack", "Bauer"));
			repository.save(new Book("Chloe", "O'Brian"));
			repository.save(new Book("Kim", "Bauer"));
			repository.save(new Book("David", "Palmer"));
			repository.save(new Book("Michelle", "Dessler"));

			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch an individual book by ID
			repository.findById(1L)
				.ifPresent(book -> {
					log.info("Book found with findById(1L):");
					log.info("--------------------------------");
					log.info(book.toString());
					log.info("");
				});

			// fetch books by last name
			log.info("Book found with findByTitle('Jack'):");
			log.info("--------------------------------------------");
			repository.findByTitle("Jack").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Book bauer : repository.findByTitle("Jack")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}

