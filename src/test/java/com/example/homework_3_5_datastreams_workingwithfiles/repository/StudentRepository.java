package com.example.homework_3_5_datastreams_workingwithfiles.repository;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

