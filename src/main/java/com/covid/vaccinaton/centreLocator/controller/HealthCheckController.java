package com.covid.vaccinaton.centreLocator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@author devanshi.dhabalia

This class is responsible to check if the application is up and running
*/
@RestController
public class HealthCheckController {

    @GetMapping("/status")
    public String checkStatus() {
        return "API is running successfully";
    }
}
