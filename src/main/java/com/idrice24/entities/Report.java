package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "sub1")
    private long sub1;

    @Column(name = "sub2")
    private long sub2;

    @Column(name = "sub3")
    private long sub3;

    @Column(name = "sub4")
    private long sub4;

    @Column(name ="sub5")
    private long sub5;

    @Column(name = "sub6")
    private long sub6;


    
    public Report() {}

    public Report(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

    public void setMatricule(String matricule){
        this.matricule = matricule;
    }

    public String getMatricule(){
         return matricule; 
    }

    public void setSub1(long sub1){
        this.sub1 = sub1;
    }

    public long getSub1(){
        return sub1;
    }

    public void setSub2(long sub2){
        this.sub2 = sub2;
    }

    public long getSub2(){
        return sub2;
    }

    public void setSub3(long sub3){
        this.sub3 = sub3;
    }

    public long getSub3(){
        return sub3;
    }

    public void setSub4(long sub4){
        this.sub4 = sub4;
    }

    public long getSub4(){
        return sub4;
    }

    public void setSub5(long sub5){
        this.sub5 = sub5;
    }

    public long getSub5(){
        return sub5;
    }

    public void setSub6(long sub6){
        this.sub6 = sub6;
    }

    public long getSub6(){
        return sub6;
    }
}
