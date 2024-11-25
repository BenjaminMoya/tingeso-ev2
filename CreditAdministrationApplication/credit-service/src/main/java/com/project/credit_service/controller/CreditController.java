package com.project.credit_service.controller;

import com.project.credit_service.entity.CreditEntity;
import com.project.credit_service.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/credit")
@CrossOrigin("*")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ArrayList<CreditEntity>> getUserCredits(@PathVariable long userId){
        return ResponseEntity.ok(creditService.getUserCredits(userId));
    }

    @GetMapping("/phase/{creditPhase}")
    public ResponseEntity<ArrayList<CreditEntity>> getPhaseCredits(@PathVariable int creditPhase){
        return ResponseEntity.ok(creditService.getPhaseCredits(creditPhase));
    }

    @GetMapping("/get/{creditId}")
    public ResponseEntity<CreditEntity> getCredit(@PathVariable long creditId){
        return ResponseEntity.ok(creditService.getCredit(creditId));
    }

    @PostMapping("/save")
    public ResponseEntity<CreditEntity> saveCredit(@RequestBody CreditEntity credit){
        try{
            return ResponseEntity.ok(creditService.saveCredit(credit));
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CreditEntity> creditUpdate(@RequestBody CreditEntity credit){
        CreditEntity newCredit = creditService.updateCredit(credit);
        return ResponseEntity.ok(newCredit);
    }

    @DeleteMapping("/delete/{creditId}")
    public int deleteCredit(@PathVariable long creditId){
        try {
            return creditService.deleteCredit(creditId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
