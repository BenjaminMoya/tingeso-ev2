package com.project.simulation_service.controller;

import com.project.simulation_service.entity.SimulationEntity;
import com.project.simulation_service.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulation")
@CrossOrigin("*")
public class SimulationController {

    @Autowired
    SimulationService simulationService;

    @GetMapping("/")
    public ResponseEntity<List<SimulationEntity>> getAll(){
        return ResponseEntity.ok(simulationService.getSimulations());
    }

    @PostMapping("/{amount}/{interest}/{years}/{userId}/{creditId}")
    public ResponseEntity<SimulationEntity> saveSimulation(@PathVariable double amount,
                                                                   @PathVariable double interest,
                                                                   @PathVariable int years,
                                                                   @PathVariable Long userId,
                                                                   @PathVariable Long creditId){
        return ResponseEntity.ok(simulationService.saveSimulation(amount,interest,years,userId,creditId));
    }
}
