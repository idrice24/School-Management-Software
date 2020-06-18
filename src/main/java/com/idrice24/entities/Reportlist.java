package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Reportlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name ="";

    @Column(name = "speciality")
    private String speciality ="";

    @Column(name = "matricule")
    private String matricule ="";
    @Column(name = "matriculeR")
    private String matriculeR ="";

    @Column(name = "math")
    private long math ;

    @Column(name = "swe")
    private long swe ;

    @Column(name = "cth")
    private long cth ;

    @Column(name = "law")
    private long law ;

    @Column(name ="eng")
    private long eng ;

    @Column(name = "pro")
    private long pro ;
    @Column(name ="dob")
    private String dob ="";
    @Column(name ="pob")
    private String pob ="";
    @Column(name ="level")
    private String level ="";


    
    public Reportlist() {}

    public Reportlist(String name) {
        this.name = name;
    
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

    public String getName() {
        return name;
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

    public void setMath(long math){
        this.math = math;
    }

    public long getMath(){
        return math;
    }

    public void setSwe(long swe){
        this.swe = swe;
    }

    public long getSwe(){
        return swe;
    }

    public void setCth(long cth){
        this.cth = cth;
    }

    public long getCth(){
        return cth;
    }

    public void setLaw(long law){
        this.law = law;
    }

    public long getLaw(){
        return law;
    }

    public void setEng(long eng){
        this.eng = eng;
    }

    public long getEng(){
        return eng;
    }

    public void setPro(long pro){
        this.pro = pro;
    }

    public long getPro(){
        return pro;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }

    public void setPob(String pob){
        this.pob = pob;
    }

    public String getPob(){
        return pob;
    }
    public void setDob( String dob){
        this.dob = dob;
    }
    public String getDob(){
        return dob;
    }
    public void setMatriculeR(String matriculeR){
        this.matriculeR = matriculeR;
    }
    public String getMatriculeR(){
        return matriculeR;
    }
}
