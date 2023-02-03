/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.controller;


import com.bank.bank.model.db.Currency;
import com.bank.bank.service.ICurrencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author J. Pablo Osuna
 */

@RestController
@RequestMapping("currency")
@CrossOrigin("*")
public class ClientController {
    
    
    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping("/list")
    public ResponseEntity<List<Currency>> list(){
        var result = iCurrencyService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
