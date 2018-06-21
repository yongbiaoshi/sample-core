package com.my.sample.core;

import com.my.sample.core.config.client.CarBasicClientProperties;
import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.dto.CarBasicResultDto;
import com.my.sample.core.entity.po.User;
import com.my.sample.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

    @Resource
    UserService userService;

    @Resource
    RestTemplate carBasicRestTemplate;

    @Resource
    CarBasicClientProperties properties;

    @Test
    public void contextLoads() {
        User user = userService.selectById(1);
        user.setCreateTime(null);
        user.setLastUpdateTime(null);
        user.setMobileNum(null);
        boolean r = userService.updateById(user);
        System.out.println(r);
        user.setModifyTime(new Date());
        r = userService.updateById(user);
        System.out.println(r);
    }

    @Test
    public void restTemplateTest() {
        CarBasicResultDto<CarBasicInfoDto> info = carBasicRestTemplate.getForObject(properties.getBaseUrl() + properties.getQueryUrl(), CarBasicResultDto.class, 1);
        System.out.println(info);
    }

}
