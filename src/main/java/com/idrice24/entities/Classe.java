package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "numhrs is mandatory")
    @Column(name = "numhrs")
    private String numhrs;

    @Column(name = "classe")
    private String classe;
    
    public Classe() {}

    public Classe(String name, String numhrs) {
        this.name = name;
        this.numhrs = numhrs;
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

    public void setNumhrs(String numhrs) {
        this.numhrs = numhrs;
    }

    public String getName() {
        return name;
    }

    public String getNumhrs() {
        return numhrs;
    }

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}