package com.goodguy.hms.dao;

import com.goodguy.hms.pojo.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingDAO extends JpaRepository<Training,Integer> {
}
