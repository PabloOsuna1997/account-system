/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.svc.impl;

import com.bank.bank.dao.inte.ClientRepositoryInte;
import com.bank.bank.model.Client;
import com.bank.bank.svc.inte.ClientSvcInte;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Pablo Osuna
 */
@Service
public class ClientSvcImpl implements ClientSvcInte {

    @Autowired
    private ClientRepositoryInte clientRepositoryInte;

    @Override
    public List<Client> findAll() {
        return clientRepositoryInte.findAll();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Client save(Client client) {
        clientRepositoryInte.save(client);
        return client;
    }

    @Override
    public Client update(int dbid, Client client) {
        Client oldClient = clientRepositoryInte.findById(dbid).get();
        oldClient.setBirthay(client.getBirthay());
        oldClient.setCui(client.getCui());
        oldClient.setEmail_address(client.getEmail_address());
        oldClient.setFirst_name(client.getFirst_name());
        oldClient.setGender(client.getGender());
        oldClient.setLast_name(client.getLast_name());
        oldClient.setMarial_status(client.getMarial_status());
        oldClient.setNit(client.getNit());
        oldClient.setPhone_number(client.getPhone_number());
        oldClient.setUser_modified(client.getUser_modified());
        return clientRepositoryInte.save(oldClient);
    }

    @Override
    @Transactional
    public boolean delete(int dbid) {
        Client oldClient = clientRepositoryInte.findById(dbid).get();
        oldClient.setStatus(2);
        return clientRepositoryInte.save(oldClient).getStatus() == 2;
    }

}
