package com.my.sample.core.service.impl;

import com.my.sample.core.entity.Employees;
import com.my.sample.core.dao.mapper.EmployeesMapper;
import com.my.sample.core.service.EmployeesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyongbiao
 * @since 2018-06-13
 */
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesService {

}
