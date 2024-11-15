package com.project.simulation_service.service;

import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    public double creditAmountSimulation(double requestedAmount,double interest,int years){

        double convertedInterest = (interest/12)/100;
        double powerPeriod = Math.pow((1+convertedInterest),years*12);
        return Math.ceil(requestedAmount * ( (convertedInterest*powerPeriod) / (powerPeriod-1) ));
    }
}
