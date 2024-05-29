package com.org.vaild.ExceptionHandling.service;

import com.org.vaild.ExceptionHandling.entity.Student;
import com.org.vaild.ExceptionHandling.exception.StudentExistException;
import com.org.vaild.ExceptionHandling.exception.StudentNotFoundException;
import com.org.vaild.ExceptionHandling.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student createStudent(Student student) {
         //before saving the student we have to check either exist or not
        Optional<Student> isStudentExists=studentRepo.findById(student.getStudentId());

        if(isStudentExists.isPresent()){
            throw  new StudentExistException("student exist with id: " +student.getStudentId());
        }else {
            studentRepo.save(student);
        }

        return student;
    }

    @Override
    public Student details(int id) throws StudentNotFoundException {
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("student details not found with id: " +id));
    }
}
