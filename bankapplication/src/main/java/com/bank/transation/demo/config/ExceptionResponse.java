package com.bank.transation.demo.config;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private HttpStatus statusCode;
    private String message;
}
