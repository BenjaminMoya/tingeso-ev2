package com.project.cost_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "costs")
@NoArgsConstructor
@AllArgsConstructor
public class CostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long costId;

    private Long costCreditId;
    private Double costMonthlyAmount;
    private Double costFinalAmount;
}
