package com.example.homework_3_5_datastreams_workingwithfiles.services;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Student;

import java.util.Collection;

public interface StudentService {
    Student add(Student student);

    Student remove(Long id);

    Student update(Student student);

    Student get(Long id);

    Collection<Student> getByAge(Integer startAge, Integer endAge);

    Collection<Student> getAll();
}
