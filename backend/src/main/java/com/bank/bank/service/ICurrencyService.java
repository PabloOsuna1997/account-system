/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.service;

import com.bank.bank.model.db.Currency;
import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
public interface ICurrencyService {
    public List<Currency> findAll();
}
