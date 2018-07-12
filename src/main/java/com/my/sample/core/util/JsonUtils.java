package com.my.sample.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.sample.core.entity.dto.CarBasicInfoDto;

import java.io.IOException;

public class JsonUtils {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree("{\"result\":\"success\",\"errorCode\":null,\"message\":null,\"data\":{\"brand\":\"北汽\",\"model\":\"EV160\",\"license\":\"鲁B12345\",\"lastUpdateTime\":\"2018-07-02 10:08:24\",\"createTime\":\"2017-02-20 04:57:57\",\"id\":\"123456\"}}");
        String result = tree.get("result").asText();
        String data = tree.get("data").toString();
        CarBasicInfoDto info = mapper.readValue(data, CarBasicInfoDto.class);
        System.out.println(result);
        System.out.println(data);
        System.out.println(info);
    }
}
