package com.project.cost_service.service;

import com.project.cost_service.entity.CostEntity;
import com.project.cost_service.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CostService {

    @Autowired
    CostRepository costRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<CostEntity> getCosts(){
        return costRepository.findAll();
    }

    public CostEntity getByCreditId(Long creditId){
        return costRepository.findByCostCreditId(creditId);
    }

    public double finalMonthlyAmount(double requestedAmount,double interest,int years){

        double desgravamen = requestedAmount * 0.0003;
        double monthlyAmount = restTemplate.getForObject("http://simulation-service/simulation/"+requestedAmount+"/"+interest+"/"+years, Double.class);
        return monthlyAmount + 20000 + desgravamen;
    }

    public double finalCreditAmount(double monthlyAmount,int years,double requestedAmount){

        int months = years * 12;
        return monthlyAmount*months + requestedAmount*0.01;
    }

    public CostEntity saveCost(double requestedAmount,double interest,int years,Long creditId){

        CostEntity temp = costRepository.findByCostCreditId(creditId);
        if(temp != null){

            return null;
        }

        CostEntity cost = new CostEntity();
        cost.setCostCreditId(creditId);
        cost.setCostMonthlyAmount(finalMonthlyAmount(requestedAmount,interest,years));
        cost.setCostFinalAmount(finalCreditAmount(cost.getCostMonthlyAmount(),years,requestedAmount));

        return costRepository.save(cost);
    }
}
