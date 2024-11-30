package com.project.evaluation_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationEntity {

    private Long simulationUserId;
    private Double simulationMonthlyAmount;
    private Double simulationFinalAmount;
}
