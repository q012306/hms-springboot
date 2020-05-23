package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User findById(int id);

    User getByUsernameAndPassword(String username,String password);
}
