package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Schfee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Matricule is mandatory")
    @Column(name = "matricule")
    private String matricule;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "amount")
    private long amount;

    @Column(name = "rest")
    private long rest;

    public Schfee() {}

    public Schfee(String name, String matricule) {
        this.name = name;
        this.matricule = matricule;
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
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getName() {
        return name;
    }

    public String getMatricule() {
        return matricule;
    }

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

    public void setAmount( long amount){
        this.amount = amount;
    }
    public long getAmount(){
        return amount;
    }

    public void setRest( long rest){
	    if(amount < 450000){
        this.rest = 450000 - amount;
	    }else{
System.out.printf("you are above the amount!!");
	    }
    }
    public long getRest(){
        return rest;
    }
}
