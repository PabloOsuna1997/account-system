/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.CurrencyTypeRepositoryInte;
import com.bank.bank.dao.inte.PersonTypeRepositoryInte;
import com.bank.bank.model.Currency;
import com.bank.bank.model.PersonType;
import com.bank.bank.svc.inte.CurrencyTypeSvcInte;
import com.bank.bank.svc.inte.PersonTypeSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class CurrencyTypeSvcImpl implements CurrencyTypeSvcInte {

    @Autowired
    private CurrencyTypeRepositoryInte currencyTypeRepositoryInte;

    @Override
    public List<Currency> findAll() {
        return currencyTypeRepositoryInte.findAll();
    }

}
