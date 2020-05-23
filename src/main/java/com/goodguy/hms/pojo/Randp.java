package com.goodguy.hms.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
//@Table(name = "randp")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Randp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "sid")
    private Integer sid;
    private String sname;
    private String sremark;

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

    public String getSremark() {
        return sremark;
    }
    public void setSremark(String sremark) {
        this.sremark = sremark;
    }
}
