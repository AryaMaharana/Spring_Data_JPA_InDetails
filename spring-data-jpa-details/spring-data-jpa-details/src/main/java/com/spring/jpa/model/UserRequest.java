package com.spring.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {

    private String userName;
    private String userAddress;


}
