package com.org.vaild.ExceptionHandling.service;

import com.org.vaild.ExceptionHandling.entity.Student;
import com.org.vaild.ExceptionHandling.exception.StudentNotFoundException;

public interface StudentService {

    public Student createStudent(Student student);

    public Student details(int id) throws StudentNotFoundException;
}
