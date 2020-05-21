package com.goodguy.hms.service;

import com.goodguy.hms.dao.DepartmentDAO;
import com.goodguy.hms.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    public List<Department> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "sid");
        return departmentDAO.findAll(sort);
    }

    public void addOrUpdate(Department department) {
        departmentDAO.save(department);
    }

    public void deleteById(int id) {
        departmentDAO.deleteById(id);
    }
}
