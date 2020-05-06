package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "firstname is mandatory")
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact")
    private String contact;

    @Column(name = "nid")
    private String nid;

    @Column(name = "address")
    private String address;

    @Column(name = "dept")
    private String dept;

    @Column(name = "degree")
    private String degree;

    @Column(name = "pic")
    private String pic;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "credate")
    private String credate;

    public Worker() {}

    public Worker(String name, String email) {
        this.firstname = firstname;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getLastname(){
        return lastname;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return birthday;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }

    public void setContact(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return contact;
    }

    public void setNid(String nid){
        this.nid = nid;
    }
    public String getNid(){
        return nid;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setDept(String dept){
        this.dept = dept;
    }
    public String getDept(){
        return dept;
    }

    public void setDegree(String degree){
        this.degree = degree;
    }
    public String getDegree(){
        return degree;
    }

    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return pic;
    }

    public void setCredate(String credate){
        this.credate = credate;
    }
    public String getCredate(){
        return credate;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
}