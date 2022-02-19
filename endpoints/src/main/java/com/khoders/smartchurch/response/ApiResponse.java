package com.khoders.smartchurch.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    public static ResponseEntity<Object> ok(String message, Object responseObj)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
//        map.put("status", status.value());
        map.put("success", true);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    public static ResponseEntity<?> created(String message, Object responseObj)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("success", true);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,HttpStatus.CREATED);
    }

    public static ResponseEntity<Object> notFound(String message, Object responseObj)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("success", false);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<Object> error(String message, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("success", false);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,HttpStatus.MULTI_STATUS);
    }
}
