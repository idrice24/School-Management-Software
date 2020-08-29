
package com.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studmark
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "course")
    private String course;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "marks")
    private Double marks;

    @Column(name = "status")
    private String status;

    @Column(name = "level")
    private long level;

    @Column(name = "credit")
    private long credit;

    public Studmark()
    {
    }

    public Studmark(String matricule, String course)
    {
        this.matricule = matricule;
        this.course = course;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public void setMatricule(String matricule)
    {
        this.matricule = matricule;
    }

    public String getMatricule()
    {
        return matricule;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getCourse()
    {
        return course;
    }

    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }

    public String getSpeciality()
    {
        return speciality;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setMarks(Double marks)
    {
        this.marks = marks;
    }

    public Double getMarks()
    {
        return marks;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setLevel(Long level)
    {
        this.level = level;
    }

    public Long getLevel()
    {
        return level;
    }

    public void setCredit(Long credit)
    {
        this.credit = credit;
    }

    public Long getCredit()
    {
        return credit;
    }
}
