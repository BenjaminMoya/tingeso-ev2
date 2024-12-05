package com.project.evaluation_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "evaluations")
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long evaluationId;

    private Long evaluationCreditId;
    private int evaluationRelationCi;
    private int evaluationRelationDi;
    private int evaluationUserSavingCapacity;
}
