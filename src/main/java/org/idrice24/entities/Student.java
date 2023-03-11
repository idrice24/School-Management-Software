package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "fullname")
    private String fullname;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phoneno")
    private String phoneno;

    @Column(name = "sui")
    private String sui;

    @Column(name = "dob")
    private String dob;

    @Column(name = "pob")
    private String pob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "section")
    private String section;

    @Column(name = "classe")
    private String classe;


    
    public Student() {}

    public Student(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

    public String getDob() {
        return dob;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    public String getSui(){
        return sui;
    } 

    public void setSui(String sui){
        this.sui = sui;
    }

    public void setPob(String pob){
        this.pob = pob;
    }

    public String getPob(){
        return pob;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
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

    public Student orElseThrow(Object object) {
	return null;
    }
    
}
