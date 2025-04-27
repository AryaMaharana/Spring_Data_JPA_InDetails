package com.spring.jpa.model;

import lombok.Data;

@Data
public class CreateTransactionDetailsResponse {

    private Integer transactionId;
    private String userName;
    private Integer amount;
    private String modeOfPayment;
}
