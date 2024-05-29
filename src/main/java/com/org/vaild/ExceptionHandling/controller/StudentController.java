package com.org.vaild.ExceptionHandling.controller;

import com.org.vaild.ExceptionHandling.entity.Student;
import com.org.vaild.ExceptionHandling.exception.StudentNotFoundException;
import com.org.vaild.ExceptionHandling.service.StudentService;
import com.org.vaild.ExceptionHandling.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid  Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }


    @GetMapping("/details/{id}")
    public ResponseEntity<?> createStudent(@PathVariable(value = "id")  int id) throws StudentNotFoundException {
        return new ResponseEntity<>(studentService.details(id), HttpStatus.CREATED);
    }
}
