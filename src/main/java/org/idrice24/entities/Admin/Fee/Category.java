package org.idrice24.entities.Admin.Fee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long charges;

    private String categoryname;

    public Category(){}

    public void setCharges(long charges){
        this.charges = charges;
    }

    public long getCharges(){
        return charges;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setCategoryname(String categoryname){
        this.categoryname = categoryname;
    }

    public String getCategoryname(){
        return categoryname;
    }
    
}
