package com.project.tracking_service.service;

import com.project.tracking_service.entity.TrackingEntity;
import com.project.tracking_service.model.CreditEntity;
import com.project.tracking_service.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    TrackingRepository trackingRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<TrackingEntity> getTrackings(){
        return trackingRepository.findAll();
    }

    public TrackingEntity getByTrackingCreditId(Long trackingCreditId){
        return trackingRepository.findByTrackingCreditId(trackingCreditId);
    }

    public TrackingEntity saveTracking(Long id){
        CreditEntity credit = restTemplate.getForObject("http://credit-service/credit/"+id,CreditEntity.class);
        TrackingEntity tracking = new TrackingEntity();
        tracking.setTrackingCreditId(id);
        tracking.setTrackingPhase(credit.getCreditPhase());
        return trackingRepository.save(tracking);
    }

    public TrackingEntity updateTracking(TrackingEntity tracking){
        return trackingRepository.save(tracking);
    }
}
