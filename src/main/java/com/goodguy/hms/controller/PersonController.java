package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Person;
import com.goodguy.hms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/api/persons")
    @CrossOrigin
    public List<Person> list(){
        return personService.list();
    }

    @PostMapping("/api/persons")
    @CrossOrigin
    public Person addOrUpdate(@RequestBody Person person){
        personService.addOrUpdate(person);
        return person;
    }

    @PostMapping("/api/personsdelete")
    @CrossOrigin
    public void delete(@RequestBody Person person){
        personService.deleteById(person.getSid());
    }
}
