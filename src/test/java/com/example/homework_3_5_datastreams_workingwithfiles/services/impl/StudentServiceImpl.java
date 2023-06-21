package com.example.homework_3_5_datastreams_workingwithfiles.services.impl;

import com.example.homework_3_5_datastreams_workingwithfiles.exceptions.EntityNotFoundException;
import com.example.homework_3_5_datastreams_workingwithfiles.model.Student;
import com.example.homework_3_5_datastreams_workingwithfiles.repository.StudentRepository;
import com.example.homework_3_5_datastreams_workingwithfiles.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Student add(Student student) {

        return repository.save(student);
    }

    @Override
    public Student remove(Long id) {
        Student student = get(id);
        repository.deleteById(id);
        return student;
    }

    @Override
    public Student update(Student student) {
        Student existedStudent = get(student.getId());
        return repository.save(student);
    }

    @Override
    public Student get(Long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Collection<Student> getByAge(Integer startAge, Integer endAge) {
        checkAge(startAge);
        checkAge(endAge);
        return repository.findStudentsByAgeBetween(startAge, endAge);
    }

    private void checkAge(Integer age) {
        if (age <= 10 || age >= 80) {
            throw new IllegalArgumentException("INCORRECT STUDENT AGE");
        }
    }

    @Override
    public Collection<Student> getAll() {
        return repository.findAll();
    }
}
