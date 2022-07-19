package com.assignment.jsonbind.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(value = {"class_details"})
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentRecordsDTO {

    private String studentIdRecord;

    private List<String> class_details_record;
}
