package com.developer.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Manjinder.rooprai
 */
@Data
public class Employee implements Serializable{

    private long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phoneNumber;

    private String address;

}
