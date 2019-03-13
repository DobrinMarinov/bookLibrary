package com.springFramework.bookLibrary.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springFramework.bookLibrary.model.Author;
import com.springFramework.bookLibrary.model.Book;
import com.springFramework.bookLibrary.model.Publisher;
import com.springFramework.bookLibrary.repositories.AuthorRepository;
import com.springFramework.bookLibrary.repositories.BookRepository;
import com.springFramework.bookLibrary.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initSomeData();
	}
	
	private void initSomeData() {
		
		Publisher harperCollins = new Publisher("Harper Collins", "Plovdiv");
		Publisher worx = new Publisher("Worx", "Sofia");
		publisherRepository.save(harperCollins);
		publisherRepository.save(worx);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE development without EJB", "23444", worx);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

}
