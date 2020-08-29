
package com.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teachlist
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    // @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "teach_id")
    private String teach_id;

    @Column(name = "num")
    private String num;

    @Column(name = "course")
    private String course;

    @Column(name = "level")
    private String level;

    @Column(name = "classe")
    private String classe;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private String date;

    @Column(name = "school")
    private String school;

    public Teachlist()
    {
    }

    public Teachlist(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getClasse()
    {
        return classe;
    }

    public void setClasse(String classe)
    {
        this.classe = classe;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setTeach_id(String steach_id)
    {
        this.teach_id = teach_id;
    }

    public String getTeac_id()
    {
        return teach_id;
    }
}
