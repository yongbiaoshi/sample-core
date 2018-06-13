package com.my.sample.core.service.impl;

import com.my.sample.core.entity.po.Salaries;
import com.my.sample.core.dao.mapper.SalariesMapper;
import com.my.sample.core.service.SalariesService;
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
public class SalariesServiceImpl extends ServiceImpl<SalariesMapper, Salaries> implements SalariesService {

}
