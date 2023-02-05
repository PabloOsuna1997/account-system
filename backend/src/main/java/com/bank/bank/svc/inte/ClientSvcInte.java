/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bank.bank.svc.inte;

import com.bank.bank.model.Client;
import java.util.List;

/**
 *
 * @author J. Pablo Osuna
 */
public interface ClientSvcInte {
    public List<Client> findAll();
    public Client findByDbid(String user);
    public Client save(Client client);
    public Client update(int dbid, Client client);
    public boolean delete(int dbid);
}
