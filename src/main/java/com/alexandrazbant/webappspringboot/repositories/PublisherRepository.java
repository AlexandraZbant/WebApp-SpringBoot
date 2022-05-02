package com.alexandrazbant.webappspringboot.repositories;

import com.alexandrazbant.webappspringboot.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
