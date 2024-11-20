package com.project.evaluation_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private String userName;
    private String userRut;
    private String userEmail;
    private String userPassword;
    private int userAge;
    private int userAccountSeniority;
    private int userWorkSeniority;
    private int userSavingCapacity;
    private double userBalance;
    private boolean userIndependent;
    private boolean executive;
}