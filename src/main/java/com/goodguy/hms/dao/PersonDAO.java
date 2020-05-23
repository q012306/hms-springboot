package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Person;
import com.goodguy.hms.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person,Integer> {
    Person findBySid(Integer sid);
}
