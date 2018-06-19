package com.my.sample.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.sample.core.config.webclient.BaiduClientProperties;
import com.my.sample.core.entity.vo.BaiduResultVo;
import com.my.sample.core.service.BaiduService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
public class BaiduServiceImpl implements BaiduService {

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private BaiduClientProperties properties;
    @Resource
    private WebClient baiduWebClient;

    @Override
    public BaiduResultVo queryByKeyword(String keyword) throws IOException {
        long timestamp = new Date().getTime();
        // 调用百度接口，查询
        String result = baiduWebClient.get()
                // 设置关键字、时间戳参数
                .uri(properties.getKeywordQueryUrl(), keyword, timestamp)
                .retrieve()
                .bodyToMono(String.class)
                .log() // 记录返回日志
                .doOnError(ex -> {
                    log.error("根据关键字查询百度，接口调用出错，keyword：" + keyword + "，timestamp：" + timestamp, ex);
                })
                .block(); // 等待返回
        // 因为百度返回的数据是jsonp格式的，所以需要手动转成对象
        return convertResult2Vo(result);
    }

    /**
     * 把百度返回的Jsonp格式的字符串，转化成{@link BaiduResultVo}
     *
     * @param result 百度返回字符串（Jsonp格式）
     * @return {@link BaiduResultVo}
     * @throws IOException json转换异常
     */
    private BaiduResultVo convertResult2Vo(String result) throws IOException {
        BaiduResultVo vo = null;
        if (!StringUtils.isEmpty(result) && result.contains("{") && result.contains("}")) {
            // 截取”{}“之间的字符串
            int s = result.indexOf("{");
            int e = result.lastIndexOf("}");
            String ss = result.substring(s, e + 1);
            // Json转对象
            vo = objectMapper.readValue(ss, BaiduResultVo.class);
        }
        return vo;
    }
}
