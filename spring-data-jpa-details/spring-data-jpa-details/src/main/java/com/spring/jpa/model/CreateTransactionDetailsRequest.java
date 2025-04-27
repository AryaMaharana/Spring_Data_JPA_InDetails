package com.spring.jpa.model;

import com.spring.jpa.entitie.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CreateTransactionDetailsRequest implements Serializable {

    private User user;
    private Integer amount;
    private String modeOfPayment;
    private Date dateOfPayment;
    private String remark;
}
