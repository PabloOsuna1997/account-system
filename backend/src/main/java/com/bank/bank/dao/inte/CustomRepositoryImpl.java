/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.dao.inte;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 * @author jegarcia
 * @param <T>
 * @param <t>
 */
public class CustomRepositoryImpl<T, t extends Serializable> extends SimpleJpaRepository<T, t>
        implements CustomRepository<T, t> {

    private final EntityManager entityManager;
    
    public CustomRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;        
    }

    @Override
    @Transactional
    public void refresh(T t) {        
        entityManager.refresh(t);
    }

}
