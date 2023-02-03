/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.service;

import com.bank.bank.model.db.Currency;
import com.bank.bank.repository.ICurrencyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Pablo Osuna
 */

@Service
public class CurrencyService implements ICurrencyService{

    @Autowired
    private ICurrencyRepository iCurrencyRepository;
     
    @Override
    public List<Currency> findAll() {
        List<Currency> list;
        try{
            list = iCurrencyRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;    }
    
}
