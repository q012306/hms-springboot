package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Training;
import com.goodguy.hms.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {
    @Autowired
    TrainingService trainingService;

    @GetMapping("/api/trainings")
    @CrossOrigin
    public List<Training> list(){
        return trainingService.list();
    }

    @PostMapping("/api/trainings")
    @CrossOrigin
    public Training addOrUpdate(@RequestBody Training training){
        trainingService.addOrUpdate(training);
        return training;
    }

    @PostMapping("/api/trainingsdelete")
    @CrossOrigin
    public void delete(@RequestBody Training training){
        trainingService.deleteById(training.getSid());
    }
}
