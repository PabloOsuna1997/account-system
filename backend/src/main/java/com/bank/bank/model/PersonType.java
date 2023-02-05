/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model;

import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

/**
 *
 * @author J. Pablo Osuna
 */

@Data
@Entity
@Table(name = "tblpersonType")
public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbid;
    @Column
    private char code;
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
