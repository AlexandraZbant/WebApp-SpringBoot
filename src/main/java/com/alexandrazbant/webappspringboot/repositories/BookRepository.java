package com.alexandrazbant.webappspringboot.repositories;

import com.alexandrazbant.webappspringboot.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
