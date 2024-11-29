package com.project.credit_service.repository;

import com.project.credit_service.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity,Long> {

    CreditEntity findByCreditId(long creditId);
    ArrayList<CreditEntity> findByCreditUserId(long creditUserId);
}
