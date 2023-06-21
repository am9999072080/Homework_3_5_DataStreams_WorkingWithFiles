package com.example.homework_3_5_datastreams_workingwithfiles.repository;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultiesByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}

