/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.model;

import lombok.Data;

/**
 *
 * @author J. Pablo Osuna
 */
@Data
public class BusinessStatus {
    private int dbid;
    private String code;
    private String discriminator;
    private String description;
}
