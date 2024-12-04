package com.project.credit_service.repository;

import com.project.credit_service.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity,Long> {

    CreditEntity findByCreditId(long creditId);
    ArrayList<CreditEntity> findByCreditUserId(long creditUserId);
    @Query(value = "SELECT credit_id FROM credits WHERE credit_user_id = :creditUserId", nativeQuery = true)
    List<Long> findCreditIdsByUserIdNative(@Param("creditUserId") Long creditUserId);
}
