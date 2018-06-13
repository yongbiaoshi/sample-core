package com.my.sample.core.service.impl;

import com.my.sample.core.entity.po.DeptManager;
import com.my.sample.core.dao.mapper.DeptManagerMapper;
import com.my.sample.core.service.DeptManagerService;
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
public class DeptManagerServiceImpl extends ServiceImpl<DeptManagerMapper, DeptManager> implements DeptManagerService {

}
