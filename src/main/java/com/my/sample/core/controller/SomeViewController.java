package com.my.sample.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class SomeViewController {

    @GetMapping("describe")
    public String describe(Model model) {
        model.addAttribute("message", "这是返回信息！！！");
        return "describe";
    }
}
