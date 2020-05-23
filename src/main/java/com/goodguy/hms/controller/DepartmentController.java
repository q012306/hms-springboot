package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Department;
import com.goodguy.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/api/departments")
    @CrossOrigin
    public List<Department> list() {
        return departmentService.list();
    }

    @PostMapping("/api/departments")
    @CrossOrigin
    public Department addOrUpdate(@RequestBody Department department) {
        departmentService.addOrUpdate(department);
        return department;
    }

    @PostMapping("/api/departmentsdelete")
    @CrossOrigin
    public void delete(@RequestBody Department department) {
        departmentService.deleteById(department.getSid());
    }
}
