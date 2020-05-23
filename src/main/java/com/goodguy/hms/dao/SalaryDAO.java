package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDAO extends JpaRepository<Salary,Integer> {
}
