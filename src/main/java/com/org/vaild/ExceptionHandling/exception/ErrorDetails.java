package com.org.vaild.ExceptionHandling.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private int statusCode;
    private LocalDateTime timestamp;
    private String errorMessage;
    private String status;

}
