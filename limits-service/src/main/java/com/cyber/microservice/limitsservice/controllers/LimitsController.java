package com.cyber.microservice.limitsservice.controllers;

import com.cyber.microservice.limitsservice.configuration.Configuration;
import com.cyber.microservice.limitsservice.pojos.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
}
