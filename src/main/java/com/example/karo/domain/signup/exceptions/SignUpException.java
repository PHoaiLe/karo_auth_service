package com.example.karo.domain.signup.exceptions;

import com.example.karo.domain.dto.CustomizedServiceException;
import com.example.karo.domain.dto.CustomizedServiceRuntimeStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class SignUpException extends Exception implements CustomizedServiceException
{
    public enum SignUpRuntimeStatus implements CustomizedServiceRuntimeStatus
    {
        SUCCESS(HttpStatus.OK, "Signed up successfully!"),
        AUTH_INFO_ALREADY_EXISTED(HttpStatus.FORBIDDEN, "This information has already existed!"),
        NOT_SUPPORTED_METHOD(HttpStatus.NOT_IMPLEMENTED, "This method is not supported!"),
        INVALID_SIGNUP_ROLE(HttpStatus.BAD_REQUEST, "Invalid role"),
        INVALID_SIGNUP_TYPE(HttpStatus.BAD_REQUEST, "Invalid sign-up type"),
        SQL_CREATED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot create new account record");

        private HttpStatusCode statusCode;
        private String message;

        private SignUpRuntimeStatus(HttpStatusCode statusCode, String message)
        {
            this.statusCode = statusCode;
            this.message = message;
        }

        @Override
        public HttpStatusCode getStatusCode()
        {
            return this.statusCode;
        }

        @Override
        public int getIntStatusCode() {
            return this.statusCode.value();
        }

        @Override
        public String getMessage()
        {
            return this.message;
        }
    }

    private SignUpRuntimeStatus runtimeStatus;

//    public static final SignUpException SUCCESS = new SignUpException(SignUpRuntimeStatus.SUCCESS);
    public static final SignUpException AUTH_INFO_ALREADY_EXISTED = new SignUpException(SignUpRuntimeStatus.AUTH_INFO_ALREADY_EXISTED);
    public static final SignUpException NOT_SUPPORTED_METHOD = new SignUpException(SignUpRuntimeStatus.NOT_SUPPORTED_METHOD);
    public static final SignUpException INVALID_SIGNUP_ROLE = new SignUpException(SignUpRuntimeStatus.INVALID_SIGNUP_ROLE);
    public static final SignUpException INVALID_SIGNUP_TYPE = new SignUpException(SignUpRuntimeStatus.INVALID_SIGNUP_TYPE);
    public static final SignUpException SQL_CREATED_ERROR = new SignUpException(SignUpRuntimeStatus.SQL_CREATED_ERROR);


    private SignUpException(SignUpRuntimeStatus runtimeStatus)
    {
        this.runtimeStatus = runtimeStatus;
    }

    @Override
    public CustomizedServiceRuntimeStatus getRuntimeStatus() {
        return this.runtimeStatus;
    }
}
