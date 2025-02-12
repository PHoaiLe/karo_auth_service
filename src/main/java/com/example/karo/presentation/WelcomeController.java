package com.example.karo.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@RequestMapping("apis/auth")
public class WelcomeController
{

    @GetMapping("/welcome")
    public CompletableFuture<ResponseEntity> welcome()
    {
        CompletableFuture<ResponseEntity> completableFuture = CompletableFuture.supplyAsync(new Supplier<ResponseEntity>() {
            @Override
            public ResponseEntity get() {
                String welcomeString = "Welcome to Auth Service";
                return new ResponseEntity(welcomeString, HttpStatus.OK);
            }
        });

        return completableFuture;
    }

}
