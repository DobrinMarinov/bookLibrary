package com.springFramework.bookLibrary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springFramework.bookLibrary.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
