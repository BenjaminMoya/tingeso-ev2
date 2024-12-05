package com.project.evaluation_service.service;

import com.project.evaluation_service.entity.EvaluationEntity;
import com.project.evaluation_service.model.SimulationEntity;
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

    public int setZero(Long creditId){
        EvaluationEntity temp = getByCreditId(creditId);
        temp.setEvaluationUserSavingCapacity(0);
        saveEvaluation(temp);
        return 1;
    }

    public int relationCI(Long creditId,double requestedAmount,double interest,int years,double monthlyEntry){
        EvaluationEntity temp = getByCreditId(creditId);
        double percentage = restTemplate.getForObject("http://simulation-service/simulation/"+requestedAmount+"/"+interest+"/"+years,Double.class);
        if(percentage/monthlyEntry > 0.35){
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

    public int minAmount(Long userId,Long creditId,double creditAmount){
        UserEntity user = restTemplate.getForObject("http://user-service/user/getById/"+userId,UserEntity.class);
        EvaluationEntity temp = getByCreditId(creditId);
        if(creditAmount*0.1 < user.getUserBalance()){
            temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
            evaluationRepository.save(temp);
            return 1;
        } else {
            return 0;
        }
    }

    public int savingHistory(Long creditId,boolean greatRetirement){
        if(greatRetirement){
            return 0;
        }
        EvaluationEntity temp = getByCreditId(creditId);
        temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
        evaluationRepository.save(temp);
        return 1;
    }

    public int periodicDeposit(Long creditId,double monthlyDeposit, double monthlyEntry, boolean isPeriodic){

        if(!isPeriodic) {
            return 0;
        }

        if(monthlyDeposit < monthlyEntry*0.05){
            return 0;
        }

        EvaluationEntity temp = getByCreditId(creditId);
        temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
        evaluationRepository.save(temp);
        return 1;
    }

    public int relationSA(Long userId, Long creditId, double creditAmount){
        UserEntity user = restTemplate.getForObject("http://user-service/user/getById/"+userId,UserEntity.class);
        EvaluationEntity temp = getByCreditId(creditId);

        if(user.getUserAccountSeniority() < 2 && user.getUserBalance() >= creditAmount*0.2){
            temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
            evaluationRepository.save(temp);
            return 1;
        }

        if(user.getUserAccountSeniority() >= 2 && user.getUserBalance() >= creditAmount*0.1){
            temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
            evaluationRepository.save(temp);
            return 1;
        }

        return 0;
    }

    public int recentOut(Long userId, Long creditId, double maxRetirement){

        UserEntity user = restTemplate.getForObject("http://user-service/user/getById/"+userId,UserEntity.class);
        EvaluationEntity temp = getByCreditId(creditId);
        if(user.getUserBalance()*0.3 < maxRetirement){
            return 0;
        }
        temp.setEvaluationUserSavingCapacity(temp.getEvaluationUserSavingCapacity()+1);
        evaluationRepository.save(temp);
        return 1;
    }
}
