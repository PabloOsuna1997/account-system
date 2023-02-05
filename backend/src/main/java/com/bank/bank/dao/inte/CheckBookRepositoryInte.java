/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.dao.inte;

import com.bank.bank.model.Account;
import com.bank.bank.model.CheckBook;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */

@Repository
public interface CheckBookRepositoryInte extends JpaRepository<CheckBook, Integer>{

    @Query("select cb from tblcheckBook cb where accountId = :account_id")
    public List<CheckBook> findByAccountId(@Param("account_id") int account_id);
}
