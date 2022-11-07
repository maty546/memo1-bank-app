package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @JoinColumn(name="accountCBU", nullable=false)
    private Long accountCBU;

    private Double value;
    private String type;

    public Transaction(){
    }

    public Long getID() {
        return ID;
    }
    public Double getValue() {
        return value;
    }
    public String getType() {
        return type;
    }
    public Long getAccount() {
        return accountCBU;
    }


    public void setValue(Double value) {
        this.value = value;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAccountCBU(Long cbu) {
        this.accountCBU = cbu;
    }

}
