package com.org.vaild.ExceptionHandling.exception;

public class StudentExistException extends RuntimeException{
    public StudentExistException(String message) {
        super(message);
    }
}
