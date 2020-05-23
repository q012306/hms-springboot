package com.goodguy.hms.service;

import com.goodguy.hms.dao.SalaryDAO;
import com.goodguy.hms.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryDAO salaryDAO;

    public List<Salary> list() {
        return salaryDAO.findAll();
    }

    public void addOrUpdate(Salary salary) {
        salaryDAO.save(salary);
    }

    public void deleteById(int id) {
        salaryDAO.deleteById(id);
    }
}
