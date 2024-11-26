package com.project.evaluation_service.service;

import com.project.evaluation_service.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EvaluationService {

    @Autowired
    RestTemplate restTemplate;

    public int relationCI(double requestedAmount,double interest,int years,double monthlyEntry){
        double percentage = (restTemplate.getForObject("http://localhost:8094/simulation/"+requestedAmount+"/"+interest+"/"+years, Double.class))/monthlyEntry;
        if(percentage > 0.35){
            return 0;
        } else {
            return 1;
        }
    }

    public int relationDI(double monthlyAmount,double debtsMonthlyAmount,double creditMonthlyAmount){
        if((monthlyAmount*0.5) > (debtsMonthlyAmount + creditMonthlyAmount)){
            return 1;
        } else {
            return 0;
        }
    }

    public int minAmount(long userId,double creditAmount){
        UserEntity user = restTemplate.getForObject("http://localhost:8097/user/get/"+userId,UserEntity.class);
        if(creditAmount*0.1 < user.getUserBalance()){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://localhost:8097/user/update",
                    HttpMethod.PUT,
                    new HttpEntity<>(user),
                    UserEntity.class
            ).getBody();
            return 1;
        } else {
            return 0;
        }
    }

    public int savingHistory(long userId,boolean greatRetirement){
        if(greatRetirement){
            return 0;
        }
        UserEntity user = restTemplate.getForObject("http://localhost:8097/user/get/"+userId,UserEntity.class);
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://localhost:8097/user/update",
                HttpMethod.PUT,
                new HttpEntity<>(user),
                UserEntity.class
        ).getBody();
        return 1;
    }

    public int periodicDeposit(long userId, double monthlyDeposit, double monthlyEntry, boolean isPeriodic){

        if(!isPeriodic) {
            return 0;
        }

        if(monthlyDeposit < monthlyEntry*0.05){
            return 0;
        }

        UserEntity user = restTemplate.getForObject("http://localhost:8097/user/get/"+userId,UserEntity.class);
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://localhost:8097/user/update",
                HttpMethod.PUT,
                new HttpEntity<>(user),
                UserEntity.class
        ).getBody();
        return 1;
    }

    public int relationSA(long userId, double creditAmount){
        UserEntity user = restTemplate.getForObject("http://localhost:8097/user/get/"+userId,UserEntity.class);

        if(user.getUserAccountSeniority() < 2 && user.getUserBalance() >= creditAmount*0.2){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://localhost:8097/user/update",
                    HttpMethod.PUT,
                    new HttpEntity<>(user),
                    UserEntity.class
            ).getBody();
            return 1;
        }

        if(user.getUserAccountSeniority() >= 2 && user.getUserBalance() >= creditAmount*0.1){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://localhost:8097/user/update",
                    HttpMethod.PUT,
                    new HttpEntity<>(user),
                    UserEntity.class
            ).getBody();
            return 1;
        }

        return 0;
    }

    public int recentOut(long userId, double maxRetirement){

        UserEntity user = restTemplate.getForObject("http://localhost:8097/user/get/"+userId,UserEntity.class);
        if(user.getUserBalance()*0.3 < maxRetirement){
            return 0;
        }
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://localhost:8097/user/update",
                HttpMethod.PUT,
                new HttpEntity<>(user),
                UserEntity.class
        ).getBody();
        return 1;
    }
}
