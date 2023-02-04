/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.AccountRepositoryInte;
import com.bank.bank.model.Account;
import com.bank.bank.model.Client;
import com.bank.bank.svc.inte.AccountSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class AccountSvcImpl implements AccountSvcInte {

    @Autowired
    private AccountRepositoryInte accountRepositoryInte;

    @Override
    public List<Account> findAll() {
        return accountRepositoryInte.findAll();
    }

    @Override
    public List<Account> findByUserId(int userId) {
        return accountRepositoryInte.findByClientId(userId);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Account save(Account client) {
        accountRepositoryInte.save(client);
        return client;
    }

    @Override
    public Account update(int dbid, Account newAccount) {
        Account oldAccount = accountRepositoryInte.findById(dbid).get();
        oldAccount.setAccount_type(newAccount.getAccount_type());
        oldAccount.setAmount(newAccount.getAmount());
        oldAccount.setCurrency(newAccount.getCurrency());
        oldAccount.setInit_vig(newAccount.getInit_vig());
        oldAccount.setFin_vig(newAccount.getFin_vig());
        oldAccount.setUser_modified(newAccount.getUser_modified());
        return accountRepositoryInte.save(oldAccount);
    }

    @Override
    @Transactional
    public boolean delete(int dbid) {
        Account oldClient = accountRepositoryInte.findById(dbid).get();
        oldClient.setStatus(2);
        return accountRepositoryInte.save(oldClient).getStatus() == 2;
    }

}
