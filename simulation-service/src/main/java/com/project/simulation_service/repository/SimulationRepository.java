package com.project.simulation_service.repository;

import com.project.simulation_service.entity.SimulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationRepository extends JpaRepository<SimulationEntity,Long> {
}
