package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity()
public class Classe{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="classename")
	private String classename;

	@Column(name="sect")
	private String sect;

	public Classe(){}
	public Classe(String classename){
		this.classename = classename;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setClassename(String classename){
		this.classename = classename;
	}

	public String getClassename(){
		return classename;
	}

	public void setSect(String sect){
		this.sect = sect;
	}

	public String getSect(){
		return sect;
	}
}
