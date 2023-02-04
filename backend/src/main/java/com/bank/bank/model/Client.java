/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author J. Pablo Osuna
 */

@Data
@Entity
@Table(name = "tblclient")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbid;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private long cui;
    @Column
    private String nit;
    @Column
    private long phone_number;
    @Column
    private String email_address;
    @Column
    @CreationTimestamp
    private Date birthay;
    @Column
    private String marial_status;
    @Column
    private int status;
    @Column
    private int person_type;
    @Column
    private int gender;   
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
