package com.project.tracking_service.controller;

import com.project.tracking_service.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracking")
@CrossOrigin("*")
public class TrackingController {

    @Autowired
    TrackingService trackingService;

    @GetMapping("/{id}")
    public int getPhase(Long id){
        return trackingService.getPhaseById(id);
    }
}
