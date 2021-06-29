package com.frankmoley.lil.fid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.frankmoley.lil.fid.aspect.Countable;
import com.frankmoley.lil.fid.aspect.Loggable;

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    public GreetingService() {
        super();
    }

    @Loggable
    @Countable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
