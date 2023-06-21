package com.example.homework_3_5_datastreams_workingwithfiles.controller;

import com.example.homework_3_5_datastreams_workingwithfiles.model.Faculty;
import com.example.homework_3_5_datastreams_workingwithfiles.model.Student;
import com.example.homework_3_5_datastreams_workingwithfiles.services.FacultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculties")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Создание факультета")
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        Faculty addedFaculty = service.add(faculty);
        return ResponseEntity.ok(addedFaculty);
    }

    @PutMapping
    @Operation(summary = "Обновление факультета")
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = service.update(faculty);


        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Удаление факультета")
    public ResponseEntity<Faculty> delete(@PathVariable Long id) {
        Faculty deletedFaculty = service.remove(id);

        return ResponseEntity.ok(deletedFaculty);
    }

    @GetMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Получение факультета по ID")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        Faculty faculty = service.get(id);

        return ResponseEntity.ok(faculty);
    }

    @GetMapping({"all"})
    @Operation(summary = "Получение всех факультетов")
    public ResponseEntity<Collection<Faculty>> getAll() {
        Collection<Faculty> faculties = service.getAll();
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("filter")
    @Operation(summary = "Получение факультетов по наименовании и по цвету")
    public ResponseEntity<Collection<Faculty>> getByNameOrColor(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) String color) {
        Collection<Faculty> faculties = service.getByNameOrColor(name, color);
        return ResponseEntity.ok(faculties);
    }


    //Создаем СВЯЗЬ между model(Faculty & Student) :ManyToOne_ManyToMany
//Создаем endPoint, который будет возвращать список студентов какого-то ID факультета
    @GetMapping("students/{facultyId}")
    @Operation(summary = "Получения студентов по факультету")// @Operation-ОПИСАНИЕ
    public ResponseEntity<List<Student>> getStudents(@PathVariable Long facultyId) {
        List<Student> students = service.get(facultyId).getStudents();//вызываем service
        return ResponseEntity.ok(students);
    }
}
