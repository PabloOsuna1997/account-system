/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.web;

import com.bank.bank.model.Client;
import com.bank.bank.svc.inte.ClientSvcInte;
import com.bank.bank.svc.inte.ResponseUtilSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author J. Pablo Osuna
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ComponentScan(basePackages = "com.bank.bank")
@RequestMapping("client/v1/")
public class AccountRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private ClientSvcInte clientSvcInte;

    @GetMapping("list")
    public ResponseEntity<Object> getList() {
        var result = clientSvcInte.findAll();
        return responseUtil.getReponse(200, result,(result.size() > 0) ?
                "Lista de usuarios" : "No existen usuarios");
    }

    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody Client client) {
        var result = clientSvcInte.save(client);
        return responseUtil.getReponse(200,result, "Usuario creado");
    }

    @PutMapping("/update/{dbid}")
    public ResponseEntity<Object> update(@PathVariable int dbid,  @RequestBody Client client) {
        var result = clientSvcInte.update(dbid, client);
        return responseUtil.getReponse(200, result, "Usuario Actualizado");
    }

    @PutMapping("/delete/{dbid}")
    public ResponseEntity<Object> delete(@PathVariable int dbid) {
        var result = clientSvcInte.delete(dbid);
        return responseUtil.getReponse( (result) ? 200 : 500, result, "Usuario eliminado");
    }
}
