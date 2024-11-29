package com.project.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {

    private Long creditUserId;
    private int creditTerm;
    private double creditPropertyAmount;
    private double creditRequestedAmount;
    private String creditFirmDate;
    private String creditReason;

    // Primera = 1, Segunda = 2, Comercial = 3, Remodelacion = 4
    private int creditType;
}
