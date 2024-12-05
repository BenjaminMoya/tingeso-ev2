package com.project.credit_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "credits")
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long creditId;

    private Long creditUserId;
    private int creditTerm;
    private double creditPropertyAmount;
    private double creditRequestedAmount;
    private String creditFirmDate;
    private String creditReason;

    // Primera = 1, Segunda = 2, Comercial = 3, Remodelacion = 4
    private int creditType;
}
