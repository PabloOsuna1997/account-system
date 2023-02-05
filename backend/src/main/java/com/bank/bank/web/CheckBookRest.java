/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.bank.web;

import com.bank.bank.model.Account;
import com.bank.bank.model.CheckBook;
import com.bank.bank.svc.inte.AccountSvcInte;
import com.bank.bank.svc.inte.CheckBookSvcInte;
import com.bank.bank.svc.inte.ResponseUtilSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author J. Pablo Osuna
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ComponentScan(basePackages = "com.bank.bank")
@RequestMapping("check-book/v1/")
public class CheckBookRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private CheckBookSvcInte checkBookSvcInte;

    @GetMapping("list")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> getList() {
        Object result;
        result = checkBookSvcInte.findAll();
        return responseUtil.getReponse(200, result, "listado de chequeras encontradas");
    }

    @GetMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> getAccountVyUserId(@PathVariable int accountId) {
        Object result;
        result = checkBookSvcInte.findByAccountId(accountId);
        return responseUtil.getReponse(200, result, "listado de chequeras encontradas");
    }


    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody CheckBook checkBook) {
        var result = checkBookSvcInte.save(checkBook);
        return responseUtil.getReponse(200,result, "Chequera creada");
    }

    @PutMapping("/update/{dbid}")
    public ResponseEntity<Object> update(@PathVariable int dbid,  @RequestBody CheckBook checkBook) {
        var result = checkBookSvcInte.update(dbid, checkBook);
        return responseUtil.getReponse(200, result, "Chequera Actualizada");
    }

    @PutMapping("/delete/{dbid}")
    public ResponseEntity<Object> delete(@PathVariable int dbid) {
        var result = checkBookSvcInte.delete(dbid);
        return responseUtil.getReponse( (result) ? 200 : 500, result, "Chequera eliminada");
    }
}
