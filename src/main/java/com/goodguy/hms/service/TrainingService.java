package com.goodguy.hms.service;

import com.goodguy.hms.dao.TrainingDAO;
import com.goodguy.hms.pojo.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainingService {
    @Autowired
    TrainingDAO trainingDAO;

    public List<Training> list() {
        return trainingDAO.findAll();
    }

    public void addOrUpdate(Training training) {
        trainingDAO.save( training );
    }

    public void deleteById(int id) {
        trainingDAO.deleteById(id);
    }
}
