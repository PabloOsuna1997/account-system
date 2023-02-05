/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author J. Pablo Osuna
 */
@Data
@Entity
@Table(name = "tblaccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbid;
    @Column(name = "client_id")
    private int  clientId;
    @Column
    private double amount ;
    @Column
    private Date init_vig;
    @Column
    private Date fin_vig;
    @Column
    private int currency;
    @Column
    private int account_type;
    @Column
    private int status;
    @Column
    @CreationTimestamp
    private Date registry_date;
    @Column
    private String user_registry ;
    @Column
    @CreationTimestamp
    private Date last_modified;
    @Column
    private String user_modified;
}
