package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Salary;
import com.goodguy.hms.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/api/salarys")
    @CrossOrigin
    public List<Salary> list(){
        return salaryService.list();
    }

    @PostMapping("/api/salarys")
    @CrossOrigin
    public Salary addOrUpdate(@RequestBody Salary salary){
        salaryService.addOrUpdate(salary);
        return salary;
    }

    @PostMapping("/api/salarysdelete")
    @CrossOrigin
    public void delete(@RequestBody Salary salary){
        salaryService.deleteById(salary.getSid());
    }
}