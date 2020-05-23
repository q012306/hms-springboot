package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Recruitment;
import com.goodguy.hms.pojo.Person;
import com.goodguy.hms.service.RecruitmentService;
import com.goodguy.hms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecruitmentController {
    @Autowired
    RecruitmentService recruitmentService;
    @Autowired
    PersonService personService;

    @GetMapping("/api/recruitments")
    @CrossOrigin
    public List<Recruitment> list() {
        return recruitmentService.list();
    }

    @PostMapping("/api/recruitments")
    @CrossOrigin
    public Recruitment addOrUpdate(@RequestBody Recruitment recruitment) {
        recruitmentService.addOrUpdate(recruitment);
        return recruitment;
    }

    @PostMapping("/api/recruitmentsdelete")
    @CrossOrigin
    public void delete(@RequestBody Recruitment recruitment) {
        recruitmentService.deleteById(recruitment.getSid());
    }

    @PostMapping("/api/personhire")
    @CrossOrigin
    public void hire(@RequestBody Recruitment recruitment) {
        Person person = new Person();
        person.setSname(recruitment.getSname());
        person.setSsex(recruitment.getssex());
        person.setSbirthday(recruitment.getSbirthday());
        person.setSedu(recruitment.getSedu());
        person.setSspcialty(recruitment.getSspcialty());
        person.setSaddress(recruitment.getSaddress());
        person.setStel(recruitment.getStel());
        person.setSemail(recruitment.getSemail());
        personService.addOrUpdate(person);
        recruitmentService.deleteById(recruitment.getSid());
    }
}
