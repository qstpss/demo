package com.example.demo;

import com.example.demo.entity.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @PersistenceContext
    EntityManager entityManager;


    public void save(Person person) {
        repository.save(person);
    }

    @Transactional(readOnly = true)
    public void edit(Long id) {
        Person byId = repository.findById(id).get();
        byId.setFirstName("changed");
        entityManager.flush();//here UPDATE occurs
    }

    public Iterable<Person> getAll() {
        return repository.findAll();
    }
}
