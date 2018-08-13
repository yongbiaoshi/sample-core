package com.my.sample.core;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Swagger2Markup {

    public static void main(String[] args) throws MalformedURLException {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .build();

        Path path = Paths.get("E:/api-docs.json");
        URL url = new URL("http://localhost:8080/v2/api-docs");
        Swagger2MarkupConverter.from(path)
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/markdown/generated/api-docs"));
//                .toFolder(Paths.get("src/docs/markdown/generated"));
    }
}
