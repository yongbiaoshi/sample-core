package com.my.sample.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通Web接口异常处理
 */
@RestController
@RequestMapping("ex")
public class ExceptionController {

    @GetMapping("")
    public int ex() {
        return 1 / 0;
    }

    @GetMapping("runtime")
    public String runtime(){
        throw new RuntimeException("测试运行时异常抛出！！");
    }

}
