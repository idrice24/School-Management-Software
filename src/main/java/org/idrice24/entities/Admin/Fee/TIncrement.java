package org.idrice24.entities.Admin.Fee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TIncrement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long incrementamount;

    public TIncrement(){  }

    public long getId(){
        return id;
    }

    public void setIncrementamount(long incrementamount){
        this.incrementamount = getIncrementamount() + 1;
    }

    public long getIncrementamount(){
        return incrementamount;
    }

    public void setId(long id){
        this.id = id;
    }
}
