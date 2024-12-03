package com.project.credit_service.controller;

import com.project.credit_service.entity.CreditEntity;
import com.project.credit_service.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
@CrossOrigin("*")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<List<CreditEntity>> getUserCredits(@PathVariable Long id){
        return ResponseEntity.ok(creditService.getUserCredits(id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CreditEntity> getCredit(@PathVariable Long id){
        return ResponseEntity.ok(creditService.getCredit(id));
    }

    @PostMapping("/listByIds")
    public ResponseEntity<List<CreditEntity>> getAllById(@RequestBody List<Long> ids){
        return ResponseEntity.ok(creditService.getCreditsByIds(ids));
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

    @DeleteMapping("/delete/{id}")
    public int deleteCredit(@PathVariable Long id){
        try {
            return creditService.deleteCredit(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
