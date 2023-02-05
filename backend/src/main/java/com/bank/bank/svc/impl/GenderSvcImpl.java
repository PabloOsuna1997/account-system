/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.GenderRepositoryInte;
import com.bank.bank.model.Gender;
import com.bank.bank.model.PersonType;
import com.bank.bank.svc.inte.GenderSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class GenderSvcImpl implements GenderSvcInte {

    @Autowired
    private GenderRepositoryInte genderRepositoryInte;

    @Override
    public List<Gender> findAll() {
        return genderRepositoryInte.findAll();
    }

}
