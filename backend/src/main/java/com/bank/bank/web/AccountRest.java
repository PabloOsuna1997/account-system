/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.web;

import com.bank.bank.model.Account;
import com.bank.bank.model.Client;
import com.bank.bank.svc.inte.AccountSvcInte;
import com.bank.bank.svc.inte.ResponseUtilSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author J. Pablo Osuna
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ComponentScan(basePackages = "com.bank.bank")
@RequestMapping("account/v1/")
public class AccountRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private AccountSvcInte accountSvcInte;

    @GetMapping("list")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> getList() {
        Object result;
        result = accountSvcInte.findAll();
        return responseUtil.getReponse(200, result, "listado de cuentas encontradas");
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> getAccountVyUserId(@PathVariable int userId) {
        Object result;
        result = accountSvcInte.findByUserId(userId);
        return responseUtil.getReponse(200, result, "listado de cuentas encontradas");
    }


    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody Account account) {
        var result = accountSvcInte.save(account);
        return responseUtil.getReponse(200,result, "Cuenta creado");
    }

    @PutMapping("/update/{dbid}")
    public ResponseEntity<Object> update(@PathVariable int dbid,  @RequestBody Account account) {
        var result = accountSvcInte.update(dbid, account);
        return responseUtil.getReponse(200, result, "Cuenta Actualizado");
    }

    @PutMapping("/delete/{dbid}")
    public ResponseEntity<Object> delete(@PathVariable int dbid) {
        var result = accountSvcInte.delete(dbid);
        return responseUtil.getReponse( (result) ? 200 : 500, result, "Cuenta eliminado");
    }
}
