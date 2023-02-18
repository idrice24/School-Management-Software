package org.idrice24.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teachers{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacher_id;

    @Column(name="teaname")
    private String teaname;

    @Column(name="teaemail")
    private String teaemail;

    @Column(name="teacourse")
    private String teacourse;

    @Column(name="teaaddress")
    private String teaaddress;

    @Column(name="teaphone")
    private String teaphone;

    @Column(name="jdate")
    private Date jdate;

    @Column(name="deptm")
    private String deptm;

    public Teachers(){}

    public Teachers(String teaname, String teaemail){
        this.teaname = teaname;
        this.teaemail = teaemail;
    }

    public void setTeacherId(long teacher_id){
        this.teacher_id = teacher_id;
    }

    public long getTeacherId() {
        return teacher_id;
    }

    public void setTeaname(String teaname){
        this.teaname = teaname;
    }

    public String getTeaname(){
        return teaname;
    }


    public void setTeaaddress(String teaaddress){
        this.teaaddress = teaaddress;
    }

    public String getTeaaddress(){
        return teaaddress;
    }

    public void setTeaemail(String teaemail){
        this.teaemail = teaemail;
    }

    public String getTeaemail(){
        return teaemail;
    }

    public void setteacourse(String teacourse){
        this.teacourse = teacourse;
    }


    public String getTeacourse(){
        return teacourse;
    }

    public void setteaphone(String teaphone){
        this.teaphone = teaphone;
    }

    public String getTeaphone(){
        return teaphone;
    }

    public void setDeptm(String deptm){
        this.deptm = deptm;
    }

    public String getDeptm(){
        return deptm;
    }

    public void setJdate(Date jdate){
        this.jdate = jdate;
    }

    public Date getJdate(){
        return jdate;
    }

}