package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Classe{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="classe_name")
	private String classeName;

	@Column(name="sect")
	private String sect;

	public Classe(){}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setClasseName(String classeName){
		this.classeName = classeName;
	}

	public String getClasseName(){
		return classeName;
	}

	public void setSect(String sect){
		this.sect = sect;
	}

	public String getSect(){
		return sect;
	}
}
