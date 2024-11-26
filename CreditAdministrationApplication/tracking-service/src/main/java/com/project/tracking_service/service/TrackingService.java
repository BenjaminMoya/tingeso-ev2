package com.project.tracking_service.service;

import com.project.tracking_service.model.CreditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackingService {

    @Autowired
    RestTemplate restTemplate;

    public int getPhaseById(Long id){
        CreditEntity credit = restTemplate.getForObject("http://localhost:8092/credit/"+id,CreditEntity.class);
        return credit.getCreditPhase();
    }
}
