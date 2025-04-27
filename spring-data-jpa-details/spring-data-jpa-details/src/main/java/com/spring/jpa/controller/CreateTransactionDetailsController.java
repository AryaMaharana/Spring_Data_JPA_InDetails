package com.spring.jpa.controller;

import com.spring.jpa.model.CreateTransactionDetailsRequest;
import com.spring.jpa.model.CreateTransactionDetailsResponse;
import com.spring.jpa.service.CreateTransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createPaymentDetails")
public class CreateTransactionDetailsController {

    private final CreateTransactionDetailsService service;

    @Autowired
    public CreateTransactionDetailsController(CreateTransactionDetailsService service) {
        this.service = service;
    }


    @PostMapping
    private ResponseEntity<CreateTransactionDetailsResponse> createTransactionDetails (@RequestBody CreateTransactionDetailsRequest createTransactionDetailsRequest){
        CreateTransactionDetailsResponse response =  service.createTransactionDetails(createTransactionDetailsRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}



