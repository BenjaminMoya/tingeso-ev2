package com.project.costs_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CostService {

    @Autowired
    RestTemplate restTemplate;

    public double finalMonthlyAmount(double requestedAmount,double interest,int years){

        double desgravamen = requestedAmount * 0.0003;
        double monthlyAmount = restTemplate.getForObject("http://localhost:8095/simulation/"+requestedAmount+"/"+interest+"/"+years, Double.class);
        return monthlyAmount + 20000 + desgravamen;
    }

    public double finalCreditAmount(double monthlyAmount,int years,double requestedAmount){

        int months = years * 12;
        return monthlyAmount*months + requestedAmount*0.01;
    }
}
