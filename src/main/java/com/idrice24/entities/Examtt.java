package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Examtt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Date is mandatory")
    @Column(name = "date")
    private String date;
    
   // @NotBlank(message = "tstart is mandatory")
    @Column(name = "tstart")
    private String tstart;

    @Column(name = "ucode")
    private String ucode;

    @Column(name = "venue")
    private String venue;

    @Column(name = "school")
    private String school;

    @Column(name = "department")
    private String department;

    @Column(name = "yrstudy")
    private String yrstudy;

    @Column(name = "tend")
    private String tend;
    
    public Examtt() {}

    public Examtt(String date, String tstart) {
        this.date = date;
        this.tstart = tstart;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTstart(String tstart) {
        this.tstart = tstart;
    }

    public String getDate() {
        return date;
    }

    public String getTstart() {
        return tstart;
    }

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

    public String getVenue(){
        return venue;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
    this.school = school;
    }

    public String getDepartment(){
        return department;
    }   

    public void setDepartment(String department){
        this.department = department;
    }

    public String getYrstudy(){
        return yrstudy;
    }

    public void setYrstudy(String yrstudy){
        this.yrstudy = yrstudy;
    }

    public String getTend(){
        return tend;
    }

    public void setTend(String tend){
        this.tend = tend;
    }
}
