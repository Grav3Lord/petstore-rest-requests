package org.petstore.config.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Config {

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL) // Логируем все запросы и ответы
                .build();
    }

    // Инициализация глобальной конфигурации
    public static void setup() {
        RestAssured.requestSpecification = getRequestSpecification();
    }
}
