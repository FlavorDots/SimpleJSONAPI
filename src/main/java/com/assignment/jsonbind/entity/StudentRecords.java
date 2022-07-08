package com.assignment.jsonbind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class StudentRecords {

    @Id
    private String student_id_record;

    @ElementCollection
    @CollectionTable(name = "list_of_class_details_records")
    private List<String> class_details_record;
}
