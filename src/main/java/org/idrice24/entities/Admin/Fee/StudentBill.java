package org.idrice24.entities.Admin.Fee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.idrice24.entities.Students.Student;

@Entity
public class StudentBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    @ManyToOne
    @JoinColumn(name ="id_student")
    private Student id_student;

    @ManyToOne
    @JoinColumn(name ="id_category")
    private Category id_category;

    @ManyToOne
    @JoinColumn(name = "id_tIncrement")
    private TIncrement id_increment;

    private String invoicedesc;


    public StudentBill(){}

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

    public void setInvoicedesc(String invoicedesc){
        this.invoicedesc = invoicedesc;
    }

    public String getInvoice(){
        return invoicedesc;
    }

    public void setStudentId(Student id_student){
        this.id_student = id_student;
    }

    public Student getStudentId(){
        return id_student;
    }

    public void setCategory(Category id_Category){
        this.id_category = id_Category;
    }

    public Category getCategory(){
        return id_category;
    }

    public void setTIncrement(TIncrement id_increment){
        this.id_increment = id_increment;
    }

    public TIncrement getTincrement(){
        return id_increment;
    }
}
