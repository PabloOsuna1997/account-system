package com.bank.bank.web;


import com.bank.bank.svc.inte.GenderSvcInte;
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
@RequestMapping("gender/v1/")
public class GenderRest {

    @Autowired
    private ResponseUtilSvcInte responseUtil;

    @Autowired
    private GenderSvcInte genderSvcInte;

    @GetMapping("list")
    public ResponseEntity<Object> getList() {
        var result = genderSvcInte.findAll();
        return responseUtil.getReponse(200, result,(result.size() > 0) ?
                "Lista de generos" : "No existen generos");
    }
}
