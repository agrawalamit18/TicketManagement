package com.content.mgnt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

    @GetMapping("/")
    String home() {
        return "Welcome to Content Management Tools!";
    }
}
