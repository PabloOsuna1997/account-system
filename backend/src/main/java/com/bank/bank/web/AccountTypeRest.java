package com.bank.bank.web;


import com.bank.bank.svc.inte.AccountSvcInte;
import com.bank.bank.svc.inte.AccountTypeSvcInte;
import com.bank.bank.svc.inte.CurrencyTypeSvcInte;
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
@RequestMapping("account/v1/")
public class AccountTypeRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private AccountTypeSvcInte accountTypeSvcInte;

    @GetMapping("type")
    public ResponseEntity<Object> getList() {
        var result = accountTypeSvcInte.findAll();
        return responseUtil.getReponse(200, result,(result.size() > 0) ?
                "Lista de tipos de cuentas" : "No existen tipos");
    }
}
