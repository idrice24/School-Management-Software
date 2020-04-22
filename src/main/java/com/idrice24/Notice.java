package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Notice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "note")
    private String note;

    @Column(name = "student")
    private String student;

    @Column(name = "teacher")
    private String teacher;
    
    //@NotBlank(message = "Score is mandatory")
    @Column(name = "yrstudy")
    private String yrstudy;

    @Column(name = "date")
    private String date;

    @Column(name="name")
    private String name;
    
    public Notice() {}

    public Notice(String note, String name) {
        this.note = note;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public void setYrstudy(String yrstudy) {
        this.yrstudy = yrstudy;
    }
    public String getYrstudy(){
        return yrstudy;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent(){
        return student;
    }

    public void setStudent(String student){
        this.student = student;
    }

    public String getTeacher(){
        return teacher;
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
}
