package com.goodguy.hms.service;

import com.goodguy.hms.dao.PersonDAO;
import com.goodguy.hms.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDAO personDAO;

    public List<Person> list() {
        return personDAO.findAll();
    }

    public void addOrUpdate(Person person) {
        personDAO.save(person);
    }

    public void deleteById(int id) {
        personDAO.deleteById(id);
    }
}
