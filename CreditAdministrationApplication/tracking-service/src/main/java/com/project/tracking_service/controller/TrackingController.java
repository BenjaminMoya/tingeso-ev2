package com.project.tracking_service.controller;

import com.project.tracking_service.entity.TrackingEntity;
import com.project.tracking_service.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
@CrossOrigin("*")
public class TrackingController {

    @Autowired
    TrackingService trackingService;

    @GetMapping("/getByTrackingCreditId/{id}")
    public ResponseEntity<TrackingEntity> getByTrackingCreditId(@PathVariable Long id){
        return  ResponseEntity.ok(trackingService.getByTrackingCreditId(id));
    }

    @GetMapping("/getTrackingCreditIds/{phase}")
    public ResponseEntity<List<Long>> getTrackingCreditIds(@PathVariable int phase){
        return ResponseEntity.ok(trackingService.getTrackingCreditIds(phase));
    }

    @PostMapping("/save")
    public ResponseEntity<TrackingEntity> saveTracking(@RequestBody TrackingEntity tracking){
        return ResponseEntity.ok(trackingService.saveTracking(tracking));
    }

    @PutMapping("/update")
    public ResponseEntity<TrackingEntity> updateTracking(@RequestBody TrackingEntity tracking){
        return ResponseEntity.ok(trackingService.saveTracking(tracking));
    }

    @DeleteMapping("/delete/{id}")
    public int deleteTracking(@PathVariable Long id){
        try{
            trackingService.deleteTracking(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
