package com.my.sample.core.service.impl;

import com.my.sample.core.entity.po.Departments;
import com.my.sample.core.dao.mapper.DepartmentsMapper;
import com.my.sample.core.service.DepartmentsService;
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
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments> implements DepartmentsService {

}
