package com.example.demo;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
