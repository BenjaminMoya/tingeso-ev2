package com.project.tracking_service.service;

import com.project.tracking_service.entity.TrackingEntity;
import com.project.tracking_service.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    TrackingRepository trackingRepository;

    public TrackingEntity getByTrackingCreditId(Long trackingCreditId){
        return trackingRepository.findByTrackingCreditId(trackingCreditId);
    }

    public TrackingEntity saveTracking(TrackingEntity tracking){
        return trackingRepository.save(tracking);
    }

    public List<Long> getTrackingCreditIds(int trackingPhase){
        return trackingRepository.findTrackingCreditIdByTrackingPhase(trackingPhase);
    }

    public int deleteTracking(Long trackingId){
        try{
            trackingRepository.deleteById(trackingId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
