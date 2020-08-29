package com.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Studlist
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private long phone;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "gender")
    private String gender;

    @Column(name = "school")
    private String school;

    @Column(name = "address")
    private String address;

    @Column(name = "level")
    private String level;

    @Column(name = "classe")
    private String classe;

    public Studlist()
    {
    }

    public Studlist(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
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

    public void setMatricule(String matricule)
    {
        this.matricule = matricule;
    }

    public String getMatricule()
    {
        return matricule;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getSchool()
    {
        return school;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }

    public void setClasse(String classe)
    {
        this.classe = classe;
    }

    public String getClasse()
    {
        return classe;
    }
}
