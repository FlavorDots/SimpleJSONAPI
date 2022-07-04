package com.assignment.jsonbind.dto;

import com.assignment.jsonbind.entity.ClassDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDTO {

    private String oid;

    private Long student_id;

    // change Object type to class details entities
    private List<ClassDTO> class_details;
}
