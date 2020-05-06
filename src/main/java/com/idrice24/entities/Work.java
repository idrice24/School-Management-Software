package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Work {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pid")
    private long pid;

    @Column(name = "eid")
    private String eid;
    
    @NotBlank(message = "Pname is mandatory")
    @Column(name = "pname")
    private String pname;
    
    @NotBlank(message = "duedate is mandatory")
    @Column(name = "duedate")
    private String duedate;

    @Column(name = "subdate")
    private String subdate;

    @Column(name = "mark")
    private long mark;

    @Column(name ="status")
    private String status;
    
    public Work() {}

    public Work(String pname, long pid) {
        this.pname = pname;
        this.pid = pid;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }
    
    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public long getPid() {
        return pid;
    }

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
    public void setDuedate(String duedate){
        this.duedate = duedate;
    }
    public String getDuedate(){
        return duedate;
    }
    public void setSubdate(String subdate){
        this.subdate = subdate;
    }
    public String getSubdate(){
        return subdate;
    }
    public void setMark(long mark){
        this.mark = mark;
    }
    public long getMark(){
        return mark;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}