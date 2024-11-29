package com.project.evaluation_service.repository;

import com.project.evaluation_service.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity,Long> {
    EvaluationEntity findByEvaluationCreditId(Long evaluationCreditId);
}
