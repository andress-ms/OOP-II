package org.amms.example.example1_app.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OperationController {
    @GetMapping("/hola")
    public Map<String, String>holaMundo(){
        Map<String, String> json = new HashMap<>();
        json.put("mensaje", "Hola mundo");
        return json;
    }

    @PostMapping("/add")
    public Map<String, Integer> add(@RequestBody Map<String, Integer> request){
        Map<String, Integer> result = new HashMap<>();
        int num1 = request.get("num1");
        int num2 = request.get("num2");
        result.put("sum", num1 + num2);
        return result;
    }

    @PostMapping("/getIVA")
    public Map<String, Double> getIVA(@RequestBody Map<String, Double> request){
        Map<String, Double> result = new HashMap<>();
            double price = request.get("price");
            double iva = price * 0.15;
            result.put("iva", iva);
            return result;
    }


}
