package com.assignment.jsonbind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class StudentRecords {

    @Id
    private String studentIdRecord;

    @ElementCollection
    @CollectionTable(name = "list_of_class_details_records")
    private List<String> class_details_record;
}
