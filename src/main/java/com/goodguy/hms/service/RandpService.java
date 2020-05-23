package com.goodguy.hms.service;

import com.goodguy.hms.dao.RandpDAO;
import com.goodguy.hms.pojo.Randp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandpService {
    @Autowired
    RandpDAO randpDAO;

    public List<Randp> list() {
        return randpDAO.findAll();
    }

    public void addOrUpdate(Randp randp) {
        randpDAO.save(randp);
    }

    public void deleteById(int id) {
        randpDAO.deleteById(id);
    }
}
