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
@Table(name = "tblcheckBook")
public class CheckBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbid;
    @Column(name = "account_Id")
    private int  accountId;
    @Column
    private long start_correlative ;
    @Column
    private long fin_correlative;
    @Column
    private int quantity_checks;
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
