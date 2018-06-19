package com.my.sample.core.controller;

import com.my.sample.core.entity.vo.BaiduResultVo;
import com.my.sample.core.service.BaiduService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 调用百度第三方接口示例代码
 * @author shiyongbiao
 */
@RestController
@RequestMapping("baidu")
public class BaiduController {

    @Resource
    BaiduService baiduService;

    /**
     * 根据关键字查询百度
     * @param keyword 查询关键字
     * @return 查询结果
     * @throws IOException IO异常
     */
    @GetMapping("keyword")
    public BaiduResultVo queryByKeyword(String keyword) throws IOException {
        return baiduService.queryByKeyword(keyword);
    }
}
