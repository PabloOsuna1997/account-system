/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.AccountTypeRepositoryInte;
import com.bank.bank.dao.inte.CurrencyTypeRepositoryInte;
import com.bank.bank.model.AccountType;
import com.bank.bank.model.Currency;
import com.bank.bank.svc.inte.AccountTypeSvcInte;
import com.bank.bank.svc.inte.CurrencyTypeSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class AccountTypeSvcImpl implements AccountTypeSvcInte {

    @Autowired
    private AccountTypeRepositoryInte accountTypeRepositoryInte;

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepositoryInte.findAll();
    }

}
