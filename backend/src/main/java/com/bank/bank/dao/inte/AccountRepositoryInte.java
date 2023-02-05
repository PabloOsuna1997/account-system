/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.dao.inte;

import com.bank.bank.model.Account;
import com.bank.bank.model.PersonType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */

@Repository
public interface AccountRepositoryInte extends JpaRepository<Account, Integer>{

    @Query("select a from tblAccount a where clientId = :client_id")
    public List<Account> findByClientId(@Param("client_id") int client_id);
}
