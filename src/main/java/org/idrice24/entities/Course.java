package org.idrice24.entities;

import javax.persistence.*;

@Entity()
public class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long co_id;

	@Column(name="co_name")
	private String co_name;

	public Course(){}

	public long getId(){
		return co_id;
	}

	public void setId(long co_id){
		this.co_id = co_id;
	}

	public String getConame(){
		return co_name;
	}

	public void setConame(String co_name){
		this.co_name = co_name;
	}
}