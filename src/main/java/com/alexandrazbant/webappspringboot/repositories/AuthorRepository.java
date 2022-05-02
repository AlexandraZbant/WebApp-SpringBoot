package com.alexandrazbant.webappspringboot.repositories;

import com.alexandrazbant.webappspringboot.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
