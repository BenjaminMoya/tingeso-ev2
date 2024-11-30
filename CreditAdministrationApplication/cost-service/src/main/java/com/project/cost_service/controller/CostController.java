package com.project.cost_service.controller;

import com.project.cost_service.entity.CostEntity;
import com.project.cost_service.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost")
@CrossOrigin("*")
public class CostController {

    @Autowired
    CostService costService;

    @GetMapping("/getByCreditId/{id}")
    public ResponseEntity<CostEntity> getByCreditId(@PathVariable Long id){
        return ResponseEntity.ok(costService.getByCreditId(id));
    }

    @PostMapping("/save/{requestedAmount}/{interest}/{years}/{creditId}")
    public ResponseEntity<CostEntity> saveCost(@PathVariable Double requestedAmount,
                                               @PathVariable Double interest,
                                               @PathVariable int years,
                                               @PathVariable Long creditId){
        return ResponseEntity.ok(costService.saveCost(requestedAmount,interest,years,creditId));
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCost(@PathVariable Long id){
        try{
            costService.deleteCost(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
