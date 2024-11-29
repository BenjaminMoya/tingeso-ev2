package com.project.credit_service.service;

import com.project.credit_service.entity.CreditEntity;
import com.project.credit_service.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    CreditRepository creditRepository;

    public ArrayList<CreditEntity> getUserCredits(long userId){
        return creditRepository.findByCreditUserId(userId);
    }

    public CreditEntity getCredit(long creditId){
        return creditRepository.findByCreditId(creditId);
    }

    public List<CreditEntity> getCreditsByIds(List<Long> creditIds) {
        return creditRepository.findAllById(creditIds);
    }

    public CreditEntity saveCredit(CreditEntity credit){
        return creditRepository.save(credit);
    }

    public CreditEntity updateCredit(CreditEntity credit){
        return creditRepository.save(credit);
    }

    public int deleteCredit(long creditId) throws Exception {
        try{
            creditRepository.deleteById(creditId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
