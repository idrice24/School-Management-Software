package org.idrice24.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="MySearchForm")
public class MySearchForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tui;
    private String sui;
    private String findate;
    private String compte;
    private String classe;
    private String feepay;

    public MySearchForm(){}

    public void setClasse(String classe){
        this.classe = classe;
    }

    public String getClasse(){
        return classe;
    }

    public void setTui(String tui){
        this.tui = tui;
    }

    public String getTui(){
        return tui;
    }

    public void setSui(String sui){
        this.sui = sui;
    }

    public String getSui(){
        return sui;
    }

    public void setFindate(String findate){
        this.findate = findate;
    }

    public String getFindate(){
        return findate;
    }

    public void setCompte(String compte){
        this.compte = compte;
    }

    public String getCompte(){
        return compte;
    }

    public void setFeepay(String feepay){
        this.feepay = feepay;
    }

    public String getFeepay(){
        return feepay;
    }
}
