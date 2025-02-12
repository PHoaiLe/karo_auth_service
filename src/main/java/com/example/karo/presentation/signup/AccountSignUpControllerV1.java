package com.example.karo.presentation.signup;

import com.example.karo.application.signup.AppSignUpService;
import com.example.karo.domain.dto.ServiceResult;
import com.example.karo.domain.signup.dto.SignUpInput;
import com.example.karo.domain.signup.exceptions.SignUpException;
import com.example.karo.infrastructure.repositories.account.entities.AccountEntity;
import com.example.karo.shared.dto.ApiResponseBody;
import com.example.karo.shared.dto.signup.EaPSignUpRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@RequestMapping("apis/auth/v1/signup")
public class AccountSignUpControllerV1
{
    private final AppSignUpService appSignUpService;

    @Autowired
    public AccountSignUpControllerV1(AppSignUpService appSignUpService)
    {
        this.appSignUpService = appSignUpService;
    }

    @PostMapping("/e_a_p")
    public CompletableFuture<ResponseEntity> signUpWithEmailPassword(@RequestBody EaPSignUpRequestBody requestBody)
    {
        CompletableFuture<ResponseEntity> completableFuture = CompletableFuture.supplyAsync(new Supplier<ResponseEntity>() {
            @Override
            public ResponseEntity get() {
                try
                {
                    SignUpInput input = requestBody.createSignUpInput(new Date());

                    ServiceResult<AccountEntity> serviceResult = appSignUpService.signUp(input);

                    ApiResponseBody apiResponseBody = ApiResponseBody.builder()
                            .statusCode(serviceResult.getRuntimeStatus().getIntStatusCode())
                            .message(serviceResult.getRuntimeStatus().getMessage())
                            .build();

                    return new ResponseEntity(apiResponseBody, serviceResult.getRuntimeStatus().getStatusCode());
                }
                catch (SignUpException exception)
                {
                    ApiResponseBody apiResponseBody = ApiResponseBody.builder()
                            .statusCode(exception.getRuntimeStatus().getIntStatusCode())
                            .message(exception.getRuntimeStatus().getMessage())
                            .build();

                    return new ResponseEntity(apiResponseBody, exception.getRuntimeStatus().getStatusCode());
                }
            }
        });

        return completableFuture;
    }
}
