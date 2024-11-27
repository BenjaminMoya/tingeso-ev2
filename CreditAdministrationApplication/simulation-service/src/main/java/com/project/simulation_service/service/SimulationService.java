package com.project.simulation_service.service;

import com.project.simulation_service.entity.SimulationEntity;
import com.project.simulation_service.repository.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationService {

    @Autowired
    SimulationRepository simulationRepository;

    public List<SimulationEntity> getSimulations(){
        return simulationRepository.findAll();
    }

    public double creditAmountSimulation(double requestedAmount,double interest,int years){

        double convertedInterest = (interest/12)/100;
        double powerPeriod = Math.pow((1+convertedInterest),years*12);
        return Math.ceil(requestedAmount * ( (convertedInterest*powerPeriod) / (powerPeriod-1) ));
    }

    public SimulationEntity saveSimulation(double requestedAmount,double interest,int years,Long userId,Long creditId){

        SimulationEntity temp = simulationRepository.findByCreditId(creditId);
        if(temp != null){

            return null;
        }

        SimulationEntity simulation = new SimulationEntity();
        simulation.setUserId(userId);
        simulation.setCreditId(creditId);
        simulation.setAmount(creditAmountSimulation(requestedAmount,interest,years));

        return simulationRepository.save(simulation);
    }
}
