package com.project.credit_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "credit")
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long creditId;

    private long creditUserId;
    private double creditPropertyAmount;
    private double creditRequestedAmount;
    private double creditProposedAmount;
    private int creditPhase;
    private int creditTerm;
    private String creditFirmDate;

    // Primera = 1, Segunda = 2, Comercial = 3, Remodelacion = 4
    private int creditType;
    private String creditReason;
}