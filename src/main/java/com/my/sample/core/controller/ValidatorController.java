package com.my.sample.core.controller;

import com.my.sample.core.entity.form.UserForm;
import io.swagger.annotations.Api;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;

@Api
@RequestMapping("valid")
@RestController
public class ValidatorController {

    @Resource
    private SmartValidator validator;

    /**
     * 必输项验证
     *
     * @param name  名
     * @param count 数量
     * @return 值
     */
    @GetMapping("")
    public String common(String name, @RequestParam(required = false, defaultValue = "1") int count) {

        return name + count;
    }

    /**
     * 手动校验（分组）
     *
     * @param form 用户信息
     * @return 成功
     */
    @PostMapping("user")
    public String createUser(@Validated UserForm form) {
        Errors errors = new BeanPropertyBindingResult(form, "UserForm");
        validator.validate(form, errors, UserForm.UserAddGroup.class, Default.class);
        if (errors.hasErrors()) {
            FieldError error = errors.getFieldError();
            String errorMsg = "参数非法，对象：%s，参数：%s，信息：%s";
            throw new IllegalArgumentException(String.format(errorMsg, error.getObjectName(), error.getField(), error.getDefaultMessage()));
        }
        return "success";
    }

    /**
     * 自动校验（分组）
     *
     * @param form 用户信息
     * @return 成功
     */
    @PatchMapping("user")
    public String updateUser(@Validated({UserForm.UserUpdateGroup.class, Default.class}) UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            FieldError error = result.getFieldError();
            String errorMsg = "参数非法，对象：%s，参数：%s，信息：%s";
            throw new IllegalArgumentException(String.format(errorMsg, error.getObjectName(), error.getField(), error.getDefaultMessage()));
        }
        return "success";
    }

}
