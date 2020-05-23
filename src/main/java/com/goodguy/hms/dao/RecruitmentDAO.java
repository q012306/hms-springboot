package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentDAO extends JpaRepository<Recruitment,Integer> {
}
