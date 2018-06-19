package com.my.sample.core.service;

import com.my.sample.core.entity.vo.BaiduResultVo;

import java.io.IOException;

public interface BaiduService {

    /**
     * 根据关键字查询百度
     *
     * @param keyword 关键字
     * @return 查询结果
     * @throws IOException Json转换失败的时候，抛出异常
     */
    BaiduResultVo queryByKeyword(String keyword) throws IOException;
}
