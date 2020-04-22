package com.idrice24.entities;


/* import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat; */
/**
 * Product entity.
 */

public class MySeachForm {
	
    private String name;
    private String date;
	private String classe;
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	 public String getDate() {
        return date;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
	
	public String getClasse() {
        return classe;
    }

    public void setDate(String date) {
        this.date = date;
    }
	
}
