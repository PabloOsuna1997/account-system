package com.bank.bank.web;


import com.bank.bank.dao.inte.CurrencyTypeRepositoryInte;
import com.bank.bank.svc.inte.CurrencyTypeSvcInte;
import com.bank.bank.svc.inte.PersonTypeSvcInte;
import com.bank.bank.svc.inte.ResponseUtilSvcInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@ComponentScan(basePackages = "com.bank.bank")
@RequestMapping("currency/v1/")
public class CurrencyTypeRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private CurrencyTypeSvcInte currencyTypeSvcInte;

    @GetMapping("list")
    public ResponseEntity<Object> getList() {
        var result = currencyTypeSvcInte.findAll();
        return responseUtil.getReponse(200, result,(result.size() > 0) ?
                "Lista de tipos de moneda" : "No existen tipos");
    }
}
