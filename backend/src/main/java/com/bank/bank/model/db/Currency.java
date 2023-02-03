/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model.db;

/**
 *
 * @author J. Pablo Osuna
 */

import java.util.Date;
import lombok.Data;

@Data
public class Currency {
    private char currency;
    private int dbid;
    private String description;
    private Date registry_date;
    private String user_registry;
    private Date last_modified;
    private String user_modified;
}
