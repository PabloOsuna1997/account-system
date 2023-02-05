/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.svc.impl;
;
import com.bank.bank.svc.inte.ResponseUtilSvcInte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ResponseUtilSvcImpl implements ResponseUtilSvcInte {

    private static final String STATUS = "status";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";
    
    @Override
    public ResponseEntity<Object> getReponse(int code, Object p, String message) {
        Map<String, Object> r = new HashMap<>();
        HttpStatus status;

        switch (code) {
            case 400:
                r.put(STATUS, 400);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.OK;
                break;
            case 401:
                r.put(STATUS, 401);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.UNAUTHORIZED;
                break;        
            case 403:
                r.put(STATUS, 403);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.UNAUTHORIZED;
                break;                                        
            case 404:
                r.put(STATUS, 404);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.NOT_FOUND;
                break;        
            case 204:
                r.put(STATUS, 204);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.NO_CONTENT;
                break;        
            case 202:
                r.put(STATUS, 202);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.ACCEPTED;
                break;        
            case 200:
                r.put(STATUS, 200);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.OK;
                break;        
            default:
                r.put(STATUS, 500);
                r.put(MESSAGE, message);
                r.put(DATA, p);
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }
        return new ResponseEntity<>(r, status);
    }

    @Override
    public String getRootCause(Throwable e) {
        if (e.getCause() == null) {                        
            return e.toString();
        }
        return getRootCause(e.getCause());
    }
    
    @Override
    public String getMessage(Throwable e) {
        if (e.getCause() == null) {                        
            return e.getMessage();
        }
        return getMessage(e.getCause());
    }
    
}
