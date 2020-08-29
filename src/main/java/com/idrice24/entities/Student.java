package com.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private long phone;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "classe")
    private String classe;

    @Column(name = "level")
    private int level;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private String dob;

    @Column(name = "pob")
    private String pob;

    @Column(name = "fees")
    private String fees;

    public Student()
    {
    }

    public Student(String name, String email)
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

    public long getPhone()
    {
        return phone;
    }

    public void setPhone(long phone)
    {
        this.phone = phone;
    }

    public String getMatricule()
    {
        return "CITAE00";
    }

    public void setMatricule(String matricule)
    {
        this.matricule = "CITAE00";
    }

    public String getClasse()
    {
        return classe;
    }

    public void setClasse(String classe)
    {
        this.classe = classe;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Column(name = "school")
    private String school;

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    @Column(name = "speciality")
    private String speciality;

    public String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }

    public void setDob(String dob)
    {
        this.dob = "dob";
    }

    public String getDob()
    {
        return dob;
    }

    public void setPob(String pob)
    {
        this.pob = "pob";
    }

    public String getPob()
    {
        return pob;
    }

    public void setFees(String fees)
    {
        this.fees = fees;
    }

    public String getFees()
    {
        return fees;
    }
}
