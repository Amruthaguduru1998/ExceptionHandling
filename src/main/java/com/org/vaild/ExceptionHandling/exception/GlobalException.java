package com.org.vaild.ExceptionHandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(StudentExistException.class)
    public ResponseEntity<?> studentExistsException(StudentExistException ex){

        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.OK.value());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setStatus(HttpStatus.OK.name());
        errorDetails.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorDetails,HttpStatus.OK);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotfound(StudentNotFoundException ex){

        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.name());
        errorDetails.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodValidation(MethodArgumentNotValidException ex) {

       List<String> fieldError= ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        Map<String, Object> errorMap=new HashMap<>();
        errorMap.put("status",HttpStatus.BAD_REQUEST.name());
        errorMap.put("statusCode", HttpStatus.BAD_REQUEST.value());
        errorMap.put("timeStamp",LocalDateTime.now());
        errorMap.put("errorMsg", fieldError);

        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
}

//    Map<String, Object> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//                errorMap.put("status", HttpStatus.BAD_REQUEST.name());
//                errorMap.put("statusCode", HttpStatus.BAD_REQUEST.value());
//                errorMap.put("timeStamp", LocalDateTime.now());
//                errorMap.put("errorMsg", ex.getMessage());
//                });
//                return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
//        }