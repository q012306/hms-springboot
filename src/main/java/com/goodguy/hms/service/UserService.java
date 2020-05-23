package com.goodguy.hms.service;

import com.goodguy.hms.dao.UserDAO;
import com.goodguy.hms.pojo.Department;
import com.goodguy.hms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public void addOrUpdate(User user) {
        userDAO.save(user);
    }

    public List<User> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return userDAO.findAll(sort);
    }
}
