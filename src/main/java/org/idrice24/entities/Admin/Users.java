package org.idrice24.entities.Admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="user_id")
    private String user_id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private boolean active;


    public Users(){}

    public Users(String name, String email){
        this.name = name;
        this.email = email;
    }


    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public String getLastName(){
        return last_name;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setUserId(String user_id){
        this.user_id = user_id;
    }

    public String getUserId(){
        return user_id;
    }

    public void setName(String name){
        this.name = name ;
    }

    public String getName(){
        return name;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean getActive(){
        return active;
    }

}