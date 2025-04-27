package com.spring.jpa.service;

import com.spring.jpa.entitie.User;
import com.spring.jpa.model.UserRequest;
import com.spring.jpa.model.UserResponse;
import com.spring.jpa.repositorie.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = new User();
        UserResponse userResponse = new UserResponse();
        user.setUserName(userRequest.getUserName());
        user.setUserAddress(userRequest.getUserAddress());
        User response = userRepo.save(user);
        userResponse.setUserId(response.getUserId());
        userResponse.setUserName(response.getUserName());
        return userResponse;
    }
}


