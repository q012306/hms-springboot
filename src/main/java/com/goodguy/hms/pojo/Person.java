package com.goodguy.hms.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "person")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;
    private String ssex;
    private String sbirthday;
    private String sdepartment;
    private String sjob;
    private String sedu;
    private String sspcialty;
    private String saddress;
    private String stel;
    private String semail;

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
    public String getssex() {
        return ssex;
    }
    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
    public String getSbirthday() {
        return sbirthday;
    }
    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }
    public String getSdepartment() {
        return sdepartment;
    }
    public void setSdepartment(String sdepartment) {
        this.sdepartment = sdepartment;
    }
    public String getSjob() {
        return sjob;
    }
    public void setSjob(String sjob) {
        this.sjob = sjob;
    }
    public String getSedu() {
        return sedu;
    }
    public void setSedu(String sedu) {
        this.sedu = sedu;
    }
    public String getSspcialty() {
        return sspcialty;
    }
    public void setSspcialty(String sspcialty) {
        this.sspcialty = sspcialty;
    }
    public String getSaddress() {
        return saddress;
    }
    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
    public String getStel() {
        return stel;
    }
    public void setStel(String stel) {
        this.stel = stel;
    }
    public String getSemail() {
        return semail;
    }
    public void setSemail(String semail) {
        this.semail = semail;
    }


}
