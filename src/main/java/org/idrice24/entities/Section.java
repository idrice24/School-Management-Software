package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Section{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sec_id;

	@Column(name = "sec_name")
	private String sec_name;

	public Section(){}

	public void setSecId(long sec_id){
		this.sec_id = sec_id;
	}

	public long getSecId(){
		return sec_id;
	}

	public void setSecName(String sec_name){
		this.sec_name = sec_name;
	}

	public String  getSecName(){
		return sec_name;
	}
}