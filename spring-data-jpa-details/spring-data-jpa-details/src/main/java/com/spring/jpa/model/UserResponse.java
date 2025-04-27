package com.spring.jpa.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {

    private Integer userId;
    private String userName;
}
