/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.AccountRepositoryInte;
import com.bank.bank.dao.inte.CheckBookRepositoryInte;
import com.bank.bank.model.Account;
import com.bank.bank.model.CheckBook;
import com.bank.bank.svc.inte.AccountSvcInte;
import com.bank.bank.svc.inte.CheckBookSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class CheckBookSvcImpl implements CheckBookSvcInte {

    @Autowired
    private CheckBookRepositoryInte checkBookRepositoryInte;

    @Override
    public List<CheckBook> findAll() {
        return checkBookRepositoryInte.findAll();
    }

    @Override
    public List<CheckBook> findByAccountId(int accountId) {
        return checkBookRepositoryInte.findByAccountId(accountId);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CheckBook save(CheckBook client) {
        checkBookRepositoryInte.save(client);
        return client;
    }

    @Override
    public CheckBook update(int dbid, CheckBook newCheckBook) {
        CheckBook oldCheckBook = checkBookRepositoryInte.findById(dbid).get();
        oldCheckBook.setQuantity_checks(newCheckBook.getQuantity_checks());
        oldCheckBook.setFin_correlative(newCheckBook.getFin_correlative());
        oldCheckBook.setStart_correlative(newCheckBook.getStart_correlative());
        oldCheckBook.setUser_modified(newCheckBook.getUser_modified());
        return checkBookRepositoryInte.save(oldCheckBook);
    }

    @Override
    @Transactional
    public boolean delete(int dbid) {
        CheckBook oldClient = checkBookRepositoryInte.findById(dbid).get();
        oldClient.setStatus(2);
        return checkBookRepositoryInte.save(oldClient).getStatus() == 2;
    }

}
