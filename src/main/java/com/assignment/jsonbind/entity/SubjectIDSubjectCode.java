package com.assignment.jsonbind.entity;

import com.assignment.jsonbind.dto.ClassDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SubjectIDSubjectCode {
    private String student_id;

    private List<ClassDetailsDTO> class_details;
}
