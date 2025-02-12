package com.example.karo.domain.signin.exceptions;

import com.example.karo.domain.dto.CustomizedServiceException;
import com.example.karo.domain.dto.CustomizedServiceRuntimeStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class SignInException extends Exception implements CustomizedServiceException
{
    public enum SignInRuntimeStatus implements CustomizedServiceRuntimeStatus
    {
        SUCCESS(HttpStatus.OK, "Signed in successfully!"),
        NOT_FOUND_AUTH_INFO(HttpStatus.NOT_FOUND, "No authentication info!");

        private HttpStatusCode statusCode;
        private String message;

        private SignInRuntimeStatus(HttpStatusCode statusCode, String message)
        {
            this.statusCode = statusCode;
            this.message = message;
        }

        @Override
        public HttpStatusCode getStatusCode() {
            return this.statusCode;
        }

        @Override
        public int getIntStatusCode() {
            return this.statusCode.value();
        }

        @Override
        public String getMessage() {
            return this.message;
        }
    }

    public static final SignInException SUCCESS = new SignInException(SignInRuntimeStatus.SUCCESS);
    public static final SignInException NOT_FOUND_AUTH_INFO = new SignInException(SignInRuntimeStatus.NOT_FOUND_AUTH_INFO);


    private SignInRuntimeStatus runtimeStatus;

    private SignInException(SignInRuntimeStatus runtimeStatus)
    {
        this.runtimeStatus = runtimeStatus;
    }

    @Override
    public CustomizedServiceRuntimeStatus getRuntimeStatus() {
        return this.runtimeStatus;
    }
}
