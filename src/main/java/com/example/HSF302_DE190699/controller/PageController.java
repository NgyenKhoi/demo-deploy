package com.example.HSF302_DE190699.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "forward:/login.html";
    }

    @GetMapping("/")
    public String defaultPage() {
        return "forward:/login.html";
    }

    @GetMapping("/management")
    public String managementPage() {
        return "forward:/management.html";
    }

    @GetMapping("/product-form")
    public String productFormPage() {
        return "forward:/product-form.html";
    }
}
