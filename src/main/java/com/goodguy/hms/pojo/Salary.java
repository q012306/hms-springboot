package com.goodguy.hms.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
//@Table(name = "salary")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "sid")
    private Integer sid;
    private String sname;
    private Integer ssalary;

    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public Integer getSsalary() {
        return ssalary;
    }
    public void setSsalary(Integer ssalary) {
        this.ssalary = ssalary;
    }
}
