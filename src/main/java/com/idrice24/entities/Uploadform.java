package com.idrice24.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Uploadform {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;


    @Column(name = "file")
    private String file;

    @Column(name = "registre")
    private String registre;
    
	public Uploadform() {}
	
    public Uploadform(String name, String email) {
        this.name = name;
        this.email = email;
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
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
     public void setRegistre(String registre) {
        this.registre = registre;
    }
    
    public String getRegistre() {
        return registre;
    }
}