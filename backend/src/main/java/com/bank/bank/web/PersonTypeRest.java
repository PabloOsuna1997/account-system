package com.bank.bank.web;


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
@RequestMapping("person-type/v1/")
public class PersonTypeRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private PersonTypeSvcInte personTypeSvcInte;

    @GetMapping("list")
    public ResponseEntity<Object> getList() {
        var result = personTypeSvcInte.findAll();
        return responseUtil.getReponse(200, result,(result.size() > 0) ?
                "Lista de tipos de persona" : "No existen tipos");
    }
}
