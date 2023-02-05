/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.svc.inte;

import org.springframework.http.ResponseEntity;


public interface ResponseUtilSvcInte {
    
    public ResponseEntity<Object> getReponse(int code, Object p, String message);
        
    public String getRootCause(Throwable e);
    
    public String getMessage(Throwable e);
    
}
