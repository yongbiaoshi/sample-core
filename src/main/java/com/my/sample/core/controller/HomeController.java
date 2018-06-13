package com.my.sample.core.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api
@RestController
public class HomeController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
