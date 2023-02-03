/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model.db;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author J. Pablo Osuna
 */

@Data
public class Client {
    private int dbid;
    private String first_name;
    private String last_name;
    private long cui;
    private String nit;
    private long phone_number;
    private String email_address;
    private Date birthay;
    private String marial_status;
    private int status;
    private int person_type;
    private int gender;      
    private Date registry_date;
    private String user_registry;
    private Date last_modified;
    private String user_modified;
}
