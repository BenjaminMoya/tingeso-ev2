package com.project.simulation_service.controller;

import com.project.simulation_service.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulation")
@CrossOrigin("*")
public class SimulationController {

    @Autowired
    SimulationService simulationService;

    @GetMapping("/{amount}/{interest}/{years}")
    public double creditAmountSimulation(@PathVariable double amount,
                                         @PathVariable double interest,
                                         @PathVariable int years){
        return simulationService.creditAmountSimulation(amount,interest,years);
    }
}
