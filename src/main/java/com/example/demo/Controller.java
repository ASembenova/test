package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Egov egov;

    public Controller(Egov egov) {
        this.egov = egov;
    }

    @GetMapping("api")
    public String getJson(){
        return egov.getJson();
    }

    @GetMapping("test")
    public String getTest(){
        return "test";
    }

}
