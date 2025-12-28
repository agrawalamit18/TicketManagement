package com.content.mgnt.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
public class home {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(appName +" is running");
    }
}
