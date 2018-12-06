package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseApi {
    @Autowired
    DatabaseMenager databaseMenager;
    @GetMapping("/create")
    public void create(){
        databaseMenager.createDB();
    }
}
