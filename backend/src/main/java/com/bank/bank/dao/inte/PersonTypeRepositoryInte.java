/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.dao.inte;

import com.bank.bank.model.PersonType;
import com.bank.bank.web.PersonTypeRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author J. Pablo Osuna
 */

@Repository
public interface PersonTypeRepositoryInte extends JpaRepository<PersonType, Integer>{

}
