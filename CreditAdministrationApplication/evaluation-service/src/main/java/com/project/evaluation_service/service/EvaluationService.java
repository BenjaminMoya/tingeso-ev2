package com.project.evaluation_service.service;

import com.project.evaluation_service.entity.EvaluationEntity;
import com.project.evaluation_service.model.UserEntity;
import com.project.evaluation_service.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    @Autowired
    RestTemplate restTemplate;

    public EvaluationEntity saveEvaluation(EvaluationEntity evaluation){
        return evaluationRepository.save(evaluation);
    }

    public EvaluationEntity getByCreditId(Long creditId){
        return evaluationRepository.findByEvaluationCreditId(creditId);
    }

    public int relationCI(Long creditId,double requestedAmount,double interest,int years,double monthlyEntry){
        EvaluationEntity temp = getByCreditId(creditId);
        double percentage = (restTemplate.getForObject("http://simulation-service/simulation/"+requestedAmount+"/"+interest+"/"+years, Double.class))/monthlyEntry;
        if(percentage > 0.35){
            temp.setEvaluationRelationCi(0);
            saveEvaluation(temp);
            return 0;
        } else {
            temp.setEvaluationRelationCi(1);
            saveEvaluation(temp);
            return 1;
        }
    }

    public int relationDI(Long creditId,double monthlyAmount,double debtsMonthlyAmount,double creditMonthlyAmount){
        EvaluationEntity temp = getByCreditId(creditId);
        if((monthlyAmount*0.5) > (debtsMonthlyAmount + creditMonthlyAmount)){
            temp.setEvaluationRelationCi(1);
            saveEvaluation(temp);
            return 1;
        } else {
            temp.setEvaluationRelationCi(0);
            saveEvaluation(temp);
            return 0;
        }
    }

    public int minAmount(long userId,double creditAmount){
        UserEntity user = restTemplate.getForObject("http://user-service/user/get/"+userId,UserEntity.class);
        if(creditAmount*0.1 < user.getUserBalance()){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://user-service/user/update",
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
        UserEntity user = restTemplate.getForObject("http://user-service/user/get/"+userId,UserEntity.class);
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://user-service/user/update",
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

        UserEntity user = restTemplate.getForObject("http://user-service/user/get/"+userId,UserEntity.class);
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://user-service/user/update",
                HttpMethod.PUT,
                new HttpEntity<>(user),
                UserEntity.class
        ).getBody();
        return 1;
    }

    public int relationSA(long userId, double creditAmount){
        UserEntity user = restTemplate.getForObject("http://user-service/user/get/"+userId,UserEntity.class);

        if(user.getUserAccountSeniority() < 2 && user.getUserBalance() >= creditAmount*0.2){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://user-service/user/update",
                    HttpMethod.PUT,
                    new HttpEntity<>(user),
                    UserEntity.class
            ).getBody();
            return 1;
        }

        if(user.getUserAccountSeniority() >= 2 && user.getUserBalance() >= creditAmount*0.1){
            user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
            restTemplate.exchange(
                    "http://user-service/user/update",
                    HttpMethod.PUT,
                    new HttpEntity<>(user),
                    UserEntity.class
            ).getBody();
            return 1;
        }

        return 0;
    }

    public int recentOut(long userId, double maxRetirement){

        UserEntity user = restTemplate.getForObject("http://user-service/user/get/"+userId,UserEntity.class);
        if(user.getUserBalance()*0.3 < maxRetirement){
            return 0;
        }
        user.setUserSavingCapacity(user.getUserSavingCapacity()+1);
        restTemplate.exchange(
                "http://user-service/user/update",
                HttpMethod.PUT,
                new HttpEntity<>(user),
                UserEntity.class
        ).getBody();
        return 1;
    }
}
