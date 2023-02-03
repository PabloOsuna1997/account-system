/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.repository;


import com.bank.bank.model.db.Currency;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author J. Pablo Osuna
 */

@Repository
public class CurrencyRepository implements ICurrencyRepository{
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Currency> findAll(){
        String SQL = "SELECT * FROM tblCurrency";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Currency.class));
    }
   
}
