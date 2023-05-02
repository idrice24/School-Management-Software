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
    private long id;

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

    @Column(name="jndate")
    private Date jndate;

    @Column(name="depmt")
    private String depmt;

    @Column(name="sui")
    private String sui;

    @Column(name="gender")
    private String gender;

    @Column(name="section")
    private String section;

    @Column(name="classe")
    private String classe;

    public Teachers(){}

    public Teachers(String teaname, String teaemail, long id){
        this.teaname = teaname;
        this.teaemail = teaemail;
        this.id = id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
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

    public void setDeptm(String depmt){
        this.depmt = depmt;
    }

    public String getDepmt(){
        return depmt;
    }

    public void setJndate(Date jndate){
        this.jndate = jndate;
    }

    public Date getJndate(){
        return jndate;
    }

    public String getSui(){
        return sui;
    }

    public void setSui(String sui){
        this.sui = sui;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setSection(String section){
        this.section = section;
    }

    public String getSection(){
        return section;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public String getClasse(){
        return classe;
    }

}