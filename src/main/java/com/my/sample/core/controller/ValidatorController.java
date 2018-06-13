package com.my.sample.core.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api
@RequestMapping("valid")
@RestController
public class ValidatorController {

    @Resource
    private SmartValidator validator;

    /**
     * 必输项验证
     * @param name 名
     * @return 值
     */
    @GetMapping("")
    public String common(@RequestAttribute(required = true) String name) {

        return name;
    }

}
