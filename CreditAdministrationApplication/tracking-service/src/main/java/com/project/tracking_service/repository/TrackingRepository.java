package com.project.tracking_service.repository;

import com.project.tracking_service.entity.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<TrackingEntity,Long> {
    TrackingEntity findByTrackingCreditId(Long trackingCreditId);
    @Query("SELECT t.trackingCreditId FROM TrackingEntity t WHERE t.trackingPhase = :phase")
    List<Long> findTrackingCreditIdByTrackingPhase(@Param("phase") int phase);
    @Query("SELECT t FROM TrackingEntity t WHERE t.trackingCreditId IN :creditIds")
    List<TrackingEntity> findTrackingsByCreditIds(@Param("creditIds") List<Long> creditIds);

}
