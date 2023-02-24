package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Takes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="pteacher")
    private String pteacher;

    public Takes(){}

	public Takes(String pteacher){
		
		this.pteacher = pteacher;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

    public String getPteacher(){
		return pteacher;
	}

	public void setPteacher(String pteacher){
		this.pteacher = pteacher;
	}

	@OneToOne
	@JoinColumn(name="teacherid")
	private Teachers teachers;
	public void setTeachers(Teachers teachers){
		this.teachers = teachers;
	}

	public Teachers getTeachers(){
		return teachers;
	}

	@OneToOne
	@JoinColumn(name="co_id")
	private Course course;
	public void setCourse(Course course){
		this.course = course;
	}
	public Course getCourse(){
		return course;
	}


	@OneToOne
	@JoinColumn(name="classe_id")
	private Classe classe;
	public void setClasse(Classe classe){
		this.classe = classe;
	}
	public Classe getClasse(){
		return classe;
	}
    
}
