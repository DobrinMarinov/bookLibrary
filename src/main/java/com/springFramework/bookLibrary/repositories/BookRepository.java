package com.springFramework.bookLibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springFramework.bookLibrary.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
