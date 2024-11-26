package com.project.tracking_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {

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
