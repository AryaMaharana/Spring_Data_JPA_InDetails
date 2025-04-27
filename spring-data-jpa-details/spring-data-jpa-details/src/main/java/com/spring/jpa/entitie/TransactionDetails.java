package com.spring.jpa.entitie;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "t_transactionDetails", schema = "sc_payment")
@Data
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false )
    private User user;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "mode_of_payment")
    private String modeOfPayment;

    @Column(name = "date_of_payment")
    private Date dateOfPayment;

    @Column(name = "remark")
    private String remark;

}
