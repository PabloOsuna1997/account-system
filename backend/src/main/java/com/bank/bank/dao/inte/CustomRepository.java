/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.dao.inte;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;


@NoRepositoryBean
public interface CustomRepository<T, t extends Serializable> extends PagingAndSortingRepository<T, t> {
    
    public void refresh(T t);

}
