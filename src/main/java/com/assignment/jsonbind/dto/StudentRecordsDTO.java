package com.assignment.jsonbind.dto;

import com.assignment.jsonbind.entity.Class;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(value = {"class_details"})
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentRecordsDTO {

    private String student_id_record;

    private List<String> class_details_record;
}
