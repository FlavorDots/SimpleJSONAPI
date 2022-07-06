package com.assignment.jsonbind.dto;

import com.assignment.jsonbind.entity.Class;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDTO {

    private String student_id;

    private Set<Class> class_details;


}
