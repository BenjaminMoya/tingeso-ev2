package com.project.evaluation_service.controller;

import com.project.evaluation_service.entity.EvaluationEntity;
import com.project.evaluation_service.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
@CrossOrigin("*")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @PostMapping("/save")
    public ResponseEntity<EvaluationEntity> saveEvaluation(@RequestBody EvaluationEntity evaluation){
        return ResponseEntity.ok(evaluationService.saveEvaluation(evaluation));
    }

    @PostMapping("/setZero/{id}")
    public int setZero(@PathVariable Long id){
        return evaluationService.setZero(id);
    }

    @GetMapping("/getByCreditId/{id}")
    public ResponseEntity<EvaluationEntity> getByCreditId(@PathVariable Long id){
        return ResponseEntity.ok(evaluationService.getByCreditId(id));
    }

    @GetMapping("/relationCI/{creditId}/{requestedAmount}/{interest}/{years}/{monthlyEntry}")
    public int relationCI(@PathVariable Long creditId,
                          @PathVariable double requestedAmount,
                          @PathVariable double interest,
                          @PathVariable int years,
                          @PathVariable double monthlyEntry){
        return evaluationService.relationCI(creditId,requestedAmount,interest,years,monthlyEntry);
    }

    @GetMapping("/relationDI/{creditId}/{monthlyAmount}/{debtsMonthlyAmount}/{creditMonthlyAmount}")
    public int relationDI(@PathVariable Long creditId,
                          @PathVariable double monthlyAmount,
                          @PathVariable double debtsMonthlyAmount,
                          @PathVariable double creditMonthlyAmount){
        return evaluationService.relationDI(creditId,monthlyAmount,debtsMonthlyAmount,creditMonthlyAmount);
    }

    @PostMapping("/min/{userId}/{creditId}/{creditAmount}")
    public int minAmount(@PathVariable long userId,
                         @PathVariable long creditId,
                         @PathVariable double creditAmount){
        return evaluationService.minAmount(userId,creditId,creditAmount);
    }

    @PostMapping("/history/{creditId}/{greatRetirement}")
    public int savingHistory(@PathVariable long creditId,
                             @PathVariable boolean greatRetirement){
        return evaluationService.savingHistory(creditId,greatRetirement);
    }

    @PostMapping("/periodic/{creditId}/{monthlyDeposit}/{monthlyEntry}/{isPeriodic}")
    public int periodicDeposit(@PathVariable long creditId,
                               @PathVariable double monthlyDeposit,
                               @PathVariable double monthlyEntry,
                               @PathVariable boolean isPeriodic){
        return evaluationService.periodicDeposit(creditId,monthlyDeposit,monthlyEntry,isPeriodic);
    }

    @PostMapping("/relation/{userId}/{creditId}/{creditAmount}")
    public int relationSA(@PathVariable long userId,
                          @PathVariable long creditId,
                          @PathVariable double creditAmount){
        return evaluationService.relationSA(userId,creditId,creditAmount);
    }

    @PostMapping("/out/{userId}/{creditId}/{maxRetirement}")
    public int recentOut(@PathVariable long userId,
                         @PathVariable long creditId,
                         @PathVariable double maxRetirement){
        return evaluationService.recentOut(userId,creditId, maxRetirement);
    }
}
