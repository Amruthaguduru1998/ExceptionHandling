package com.org.vaild.ExceptionHandling.repo;

import com.org.vaild.ExceptionHandling.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
