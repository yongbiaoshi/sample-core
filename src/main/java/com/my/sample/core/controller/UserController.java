package com.my.sample.core.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.my.sample.core.entity.po.User;
import com.my.sample.core.entity.qo.UserQo;
import com.my.sample.core.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Resource
    PageableHandlerMethodArgumentResolver resolver;

    @Resource
    private UserService userService;

    /**
     * 根据条件分页查询用户基础信息
     *
     * @param qo 查询条件
     * @return 用户信息集合
     */
    @GetMapping("")
    public List<User> list(UserQo qo, Pageable page) {
        return null;
    }

    /**
     * 根据UID查询用户基础信息
     *
     * @return 用户信息
     */
    @GetMapping("/{uid}")
    public User findById(@PathVariable String uid) {
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.and().eq("uid", uid);
        return userService.selectOne(wrapper);
    }

}
