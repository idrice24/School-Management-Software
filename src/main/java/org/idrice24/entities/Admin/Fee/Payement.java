package org.idrice24.entities.Admin.Fee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date paymentdate;
    private long payment = 0;

    public Payement(){}

    public void setPayment(long payment){
        this.payment = payment;
    }

    public long getPayment(){
        return payment;
    }

    public void setPaymentdate(Date paymentdate){
        this.paymentdate = paymentdate;
    }

    public Date getPaymentdate(){
        return paymentdate;
    }
    
}
