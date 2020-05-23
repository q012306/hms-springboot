package com.goodguy.hms.service;

import com.goodguy.hms.dao.RecruitmentDAO;
import com.goodguy.hms.pojo.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruitmentService {
    @Autowired
    RecruitmentDAO recruitmentDAO;

    public List<Recruitment> list() {
        return recruitmentDAO.findAll();
    }

    public void addOrUpdate(Recruitment recruitment) {
        recruitmentDAO.save( recruitment );
    }

    public void deleteById(int id) {
        recruitmentDAO.deleteById(id);
    }
}
