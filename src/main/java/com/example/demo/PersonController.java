package com.example.demo;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/edit/{id}")
    public void editById(@PathVariable Long id) {
        service.edit(id);
    }

    @GetMapping("/save")
    public void createPerson() {
        Person person = new Person("firstName", "lastName", 12);
        service.save(person);
    }

    @GetMapping("/all")
    public Iterable<Person> getAllPerson() {
        return service.getAll();
    }

}
