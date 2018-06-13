package com.my.sample.core.service.impl;

import com.my.sample.core.entity.DeptEmp;
import com.my.sample.core.dao.mapper.DeptEmpMapper;
import com.my.sample.core.service.DeptEmpService;
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
public class DeptEmpServiceImpl extends ServiceImpl<DeptEmpMapper, DeptEmp> implements DeptEmpService {

}
