package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class ControlerRestApi {
     @Autowired
     Service service;
     @RequestMapping(value = "/sendMessage",method= RequestMethod.POST)
    public void createNewMessage (@RequestBody String message){
         service.messageList.add(message);
     }
}
