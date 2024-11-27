package com.project.costs_service.controller;

import com.project.costs_service.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cost")
@CrossOrigin("*")
public class CostController {

    @Autowired
    CostService costService;

    @GetMapping("/month/{requestedAmount}/{interest}/{years}")
    public double finalMonthlyAmount(@PathVariable double requestedAmount,
                                     @PathVariable double interest,
                                     @PathVariable int years){

        return costService.finalMonthlyAmount(requestedAmount,interest,years);
    }

    @GetMapping("/final/{monthlyAmount}/{years}/{requestedAmount}")
    public double finalCreditAmount(@PathVariable double monthlyAmount,
                                    @PathVariable int years,
                                    @PathVariable double requestedAmount){

        return costService.finalCreditAmount(monthlyAmount,years,requestedAmount);
    }
}
