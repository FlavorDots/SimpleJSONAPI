package com.assignment.jsonbind.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Student {

    @Id
    private String student_id;

    @ManyToMany
    @JoinTable(
            name = "student_classes_mapping",
            joinColumns = @JoinColumn(name = "student_student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_subject_code")
    )
    private Set<Class> class_details;
}
