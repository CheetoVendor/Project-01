package com.revatureproject01.project01;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproject01.project01.entity.Account;

public class LoginAccountTest {
    ApplicationContext app;
    HttpClient webClient;
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws InterruptedException {
        webClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        String[] args = new String[] {};
        app = SpringApplication.run(Project01Application.class, args);
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        SpringApplication.exit(app);
    }

    @Test
    public void loginSuccessful() throws IOException, InterruptedException {
        String json = "{\"accountId\":0,\"username\":\"test\",\"password\":\"test\"}";
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/login"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status);
        ObjectMapper om = new ObjectMapper();
        Account expectedResult = new Account(1, "test", "test");
        Account actualResult = om.readValue(response.body().toString(), Account.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
