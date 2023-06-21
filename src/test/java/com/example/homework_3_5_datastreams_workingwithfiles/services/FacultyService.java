package com.example.homework_3_5_datastreams_workingwithfiles.services;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty remove(Long id);

    Faculty update(Faculty faculty);

    Faculty get(Long id);

    Collection<Faculty> getByNameOrColor(String name, String color);

    Collection<Faculty> getAll();
}
