package com.example.homework_3_5_datastreams_workingwithfiles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
@Entity(name = "faculties")
@JsonIgnoreProperties(value = {"students"})
public class Faculty {

}
