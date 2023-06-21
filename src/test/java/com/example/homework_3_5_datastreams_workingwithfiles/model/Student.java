package com.example.homework_3_5_datastreams_workingwithfiles.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;


    //Создаем СВЯЗЬ между model(Faculty & Student):ManyToOne_ManyToMany
    @ManyToOne  //@ManyToOne-для связи между model(Faculty & Student)
    @JoinColumn(name = "faculty_id")  //@JoinColumn-применяется(где владелец сущности) на основании чего будет работать связь,,"faculty_id"-игнорируем
    @JsonBackReference  //
    private Faculty faculty;//добавляем поле Faculty

    //Создаем 2-ой конструктор со добавлением faculty + getter and setter
    public Student(Long id, String name, Integer age, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.faculty = faculty;
    }



    public Student() {
    }

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
