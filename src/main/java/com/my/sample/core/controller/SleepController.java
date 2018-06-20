package com.my.sample.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sleep")
public class SleepController {

    @GetMapping("")
    public String sleep(Integer l) throws InterruptedException {
        Thread.sleep(l * 1000);
        return "success";
    }
}
