package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Randp;
import com.goodguy.hms.service.RandpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RandpController {
    @Autowired
    RandpService randpService;

    @GetMapping("/api/randps")
    @CrossOrigin
    public List<Randp> list(){
        return randpService.list();
    }

    @PostMapping("/api/randps")
    @CrossOrigin
    public Randp addOrUpdate(@RequestBody Randp randp){
        randpService.addOrUpdate(randp);
        return randp;
    }

    @PostMapping("/api/randpsdelete") //shanchu!
    @CrossOrigin
    public void delete(@RequestBody Randp randp){
        randpService.deleteById(randp.getSid());
    }
}