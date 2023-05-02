package org.idrice24.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="fees")
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="sui")
    private String sui;

    @Column(name="pmdate")
    @JsonFormat(pattern = "yyy-mm-dd HH:mm:ss")
    private Date pmdate;

    @Column(name="amount")
    private long amount;

    @Column(name="rest")
    private long rest;

    @Column(name="total")
    private long total;

    @Column(name="classe")
    private String classe;

    @Column(name="yearp")
    @JsonFormat(pattern = "yyyy")
    private Date yearp;

    @Column(name="fullname")
    private String fullname;

    public Fees(){}

    public Fees(long id, long amount){
        this.amount = amount;
        this.id = id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setAmount(long amount){
        this.amount = amount;
    }

    public long getAmount(){
        return amount;
    }

    public void setSui(String sui){
        this.sui = sui;
    }

    public String getSui(){
        return sui;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public String getClasse(){
        return classe;
    }

    public Date getPmdate(){
        return pmdate;
    }

    public void setPmdate(Date date){
        this.pmdate = date;
    }

    public void setRest(long rest){
        this.rest = rest;
    }

    public long getRest(){
        return rest;
    }

    public void setTotal(long total){
        this.total = total;
    }

    public long getTotal(){
        return total;
    }

    public void setYearp(Date yearp){
        this.yearp = yearp;
    }
    public Date getYearp(){
        return yearp;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname(){
        return fullname;
    }

}
