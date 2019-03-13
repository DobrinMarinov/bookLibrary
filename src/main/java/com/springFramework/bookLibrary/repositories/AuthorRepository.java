package com.springFramework.bookLibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springFramework.bookLibrary.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
