/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model;

/**
 *
 * @author J. Pablo Osuna
 */

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tblaccountType")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @CreationTimestamp
    private Date registry_date;
    @Column
    private String user_registry;
    @Column
    @CreationTimestamp
    private Date last_modified;
    @Column
    private String user_modified;
}
