package com.example.karo.presentation.signin;

import com.example.karo.shared.dto.signin.SignInStandardRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@RequestMapping(path = "apis/auth/v1/signin")
public class AccountSignInControllerV1
{
    @PostMapping(path = "/standard")
    public CompletableFuture<ResponseEntity> signInByStandardAccount(@RequestBody SignInStandardRequestBody requestBody)
    {
        CompletableFuture<ResponseEntity> response = CompletableFuture.supplyAsync(new Supplier<ResponseEntity>() {
            @Override
            public ResponseEntity get() {

            }
        })
    }
}
