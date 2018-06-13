package com.my.sample.core.service.impl;

import com.my.sample.core.entity.po.User;
import com.my.sample.core.dao.mapper.UserMapper;
import com.my.sample.core.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
