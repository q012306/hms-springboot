package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department,Integer> {
}
