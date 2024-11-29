package com.project.tracking_service.repository;

import com.project.tracking_service.entity.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<TrackingEntity,Long> {
    TrackingEntity findByTrackingCreditId(Long trackingCreditId);
    List<Long> findTrackingCreditIdByTrackingPhase(int trackingPhase);
}
