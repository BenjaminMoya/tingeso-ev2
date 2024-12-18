package com.project.user_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long userId;

    private String userName;
    private String userRut;
    private String userEmail;
    private String userPassword;
    private int userAge;
    private int userAccountSeniority;
    private int userWorkSeniority;
    private double userBalance;
    private boolean userIndependent;
    private boolean userExecutive;
}
