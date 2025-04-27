package com.spring.jpa.service;

import com.spring.jpa.entitie.TransactionDetails;
import com.spring.jpa.entitie.User;
import com.spring.jpa.model.CreateTransactionDetailsRequest;
import com.spring.jpa.model.CreateTransactionDetailsResponse;
import com.spring.jpa.repositorie.CreateTransactionDetailsRepo;
import com.spring.jpa.repositorie.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class CreateTransactionDetailsService {

    private final CreateTransactionDetailsRepo createTransactionDetailsRepo;
    private final UserRepo userRepo;

    @Autowired
    public CreateTransactionDetailsService(CreateTransactionDetailsRepo createTransactionDetailsRepo, UserRepo userRepo) {
        this.createTransactionDetailsRepo = createTransactionDetailsRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public CreateTransactionDetailsResponse createTransactionDetails(CreateTransactionDetailsRequest createTransactionDetailsRequest) {
        CreateTransactionDetailsResponse response = new CreateTransactionDetailsResponse();
        TransactionDetails transactionDetails = new TransactionDetails();
        User user = userRepo.findByUserName(createTransactionDetailsRequest.getUser().getUserName());
        User userMapping = new User();
        if (Objects.isNull(user)) {
            // create new User
            userMapping.setUserName(createTransactionDetailsRequest.getUser().getUserName());
            userMapping.setUserAddress(createTransactionDetailsRequest.getUser().getUserAddress());
            userRepo.save(userMapping);
            transactionDetails.setUser(userMapping);
        } else {
            transactionDetails.setUser(user);
        }

        transactionDetails.setAmount(createTransactionDetailsRequest.getAmount());
        transactionDetails.setModeOfPayment(createTransactionDetailsRequest.getModeOfPayment());
        transactionDetails.setDateOfPayment(new Date());
        transactionDetails.setRemark(createTransactionDetailsRequest.getRemark());

        //Create new Transaction
        TransactionDetails userResponse = createTransactionDetailsRepo.save(transactionDetails);

        response.setTransactionId(userResponse.getTransactionId());
        response.setAmount(userResponse.getAmount());
        response.setModeOfPayment(userResponse.getModeOfPayment());
        response.setUserName(userResponse.getUser().getUserName());

        return response;
    }
}
