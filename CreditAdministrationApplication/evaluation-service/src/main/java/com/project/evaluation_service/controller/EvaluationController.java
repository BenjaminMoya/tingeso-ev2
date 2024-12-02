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

    @GetMapping("/getByCreditId/{id}")
    public ResponseEntity<EvaluationEntity> getByCreditId(@PathVariable Long id){
        return ResponseEntity.ok(evaluationService.getByCreditId(id));
    }

    @GetMapping("/relationCI/{creditId}/{monthlyAmount}//{monthlyEntry}")
    public int relationCI(@PathVariable Long creditId,
                          @PathVariable double monthlyAmount,
                          @PathVariable double monthlyEntry){
        return evaluationService.relationCI(creditId,monthlyAmount,monthlyEntry);
    }

    @GetMapping("/relationDI/{creditId}/{monthlyAmount}/{debtsMonthlyAmount}/{creditMonthlyAmount}")
    public int relationDI(@PathVariable Long creditId,
                          @PathVariable double monthlyAmount,
                          @PathVariable double debtsMonthlyAmount,
                          @PathVariable double creditMonthlyAmount){
        return evaluationService.relationDI(creditId,monthlyAmount,debtsMonthlyAmount,creditMonthlyAmount);
    }

    @PostMapping("/min/{userId}/{creditAmount}")
    public int minAmount(@PathVariable long userId,
                         @PathVariable double creditAmount){
        return evaluationService.minAmount(userId,creditAmount);
    }

    @PostMapping("/history/{userId}/{greatRetirement}")
    public int savingHistory(@PathVariable long userId,
                             @PathVariable boolean greatRetirement){
        return evaluationService.savingHistory(userId,greatRetirement);
    }

    @PostMapping("/periodic/{userId}/{monthlyDeposit}/{monthlyEntry}/{isPeriodic}")
    public int periodicDeposit(@PathVariable long userId,
                               @PathVariable double monthlyDeposit,
                               @PathVariable double monthlyEntry,
                               @PathVariable boolean isPeriodic){
        return evaluationService.periodicDeposit(userId,monthlyDeposit,monthlyEntry,isPeriodic);
    }

    @PostMapping("/relation/{userId}/{creditAmount}")
    public int relationSA(@PathVariable long userId,
                          @PathVariable double creditAmount){
        return evaluationService.relationSA(userId,creditAmount);
    }

    @PostMapping("/out/{userId}/{maxRetirement}")
    public int recentOut(@PathVariable long userId,
                         @PathVariable double maxRetirement){
        return evaluationService.recentOut(userId, maxRetirement);
    }
}
