package com.project.simulation_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "simulations")
@NoArgsConstructor
@AllArgsConstructor
public class SimulationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long simulationId;

    private Long userId;
    private Long creditId;
    private Double amount;
}
