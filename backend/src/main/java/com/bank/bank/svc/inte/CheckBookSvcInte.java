/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.svc.inte;

import com.bank.bank.model.Account;
import com.bank.bank.model.CheckBook;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
public interface CheckBookSvcInte {
    public List<CheckBook> findAll();
    public CheckBook save(CheckBook checkbook);
    public CheckBook update(int dbid, CheckBook checkbook);
    public boolean delete(int dbid);
    public List<CheckBook> findByAccountId(int accountId);
}
