package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person,Integer> {
}
