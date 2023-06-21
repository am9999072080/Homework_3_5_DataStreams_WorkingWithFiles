package com.example.homework_3_5_datastreams_workingwithfiles.repository;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findStudentsByAgeBetween(Integer startAge, Integer endAge);
}

