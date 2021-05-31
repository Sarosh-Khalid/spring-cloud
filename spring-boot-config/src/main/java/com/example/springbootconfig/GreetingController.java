package com.example.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("some static value")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment env;

    public GreetingController(){}

    @GetMapping("/greeting")
    public String greeting(){
        return "my.greeting: " + greetingMessage + " db.connection: " + dbSettings.getConnection() + ", " + dbSettings.getHost()
        + ", " + dbSettings.getPort();
    }

}
