package com.osqure.zabbot.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  

@RestController  

public class ZabbotHomeController {  

	@RequestMapping("/home")  
    public String getZabbotHome(){  
        return"home!";  
    }  
}  