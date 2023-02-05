/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.PersonTypeRepositoryInte;
import com.bank.bank.model.PersonType;
import com.bank.bank.svc.inte.PersonTypeSvcInte;
import com.bank.bank.web.PersonTypeRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class PersonTypeSvcImpl implements PersonTypeSvcInte {

    @Autowired
    private PersonTypeRepositoryInte personTypeRepositoryInte;

    @Override
    public List<PersonType> findAll() {
        return personTypeRepositoryInte.findAll();
    }

}
