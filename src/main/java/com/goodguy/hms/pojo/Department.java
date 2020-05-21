package com.goodguy.hms.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Integer sid;
    private String ename;
    private String emanager;
    private String eintro;

    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getEmanager() {
        return emanager;
    }
    public void setEmanager(String emanager) {
        this.emanager = emanager;
    }
    public String getEintro() {
        return eintro;
    }
    public void setEintro(String eintro) {
        this.eintro = eintro;
    }
}
