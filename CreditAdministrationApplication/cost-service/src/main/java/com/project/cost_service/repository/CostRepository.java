package com.project.cost_service.repository;

import com.project.cost_service.entity.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<CostEntity,Long> {
    CostEntity findByCostCreditId(Long creditId);
}
