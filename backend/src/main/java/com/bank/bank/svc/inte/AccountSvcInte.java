/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.svc.inte;

import com.bank.bank.model.Account;
import com.bank.bank.model.Client;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
public interface AccountSvcInte {
    public List<Account> findAll();
    public Account save(Account account);
    public Account update(int dbid, Account account);
    public boolean delete(int dbid);
    public List<Account> findByUserId(int userId);
}
