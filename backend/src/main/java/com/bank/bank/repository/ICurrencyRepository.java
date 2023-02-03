/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.repository;

import com.bank.bank.model.db.Currency;
import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
public interface ICurrencyRepository {
        public List<Currency> findAll();
}
