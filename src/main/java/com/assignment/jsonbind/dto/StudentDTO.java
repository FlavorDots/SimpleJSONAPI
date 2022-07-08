package com.assignment.jsonbind.dto;

import com.assignment.jsonbind.entity.Class;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.Set;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreProperties(value = {"class_details"})
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDTO {

    private String student_id;

    private Set<Class> class_details;

    private Map<String, String> classID_classDescription;

}
