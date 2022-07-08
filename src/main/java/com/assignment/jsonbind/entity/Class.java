package com.assignment.jsonbind.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Class {

    @Id
    private String subject_code;

    @Column
    private String subject_desc;

    @Column
    private Date week_start_date;

    @Column
    private Date week_end_date;

    @Column
    private Date exact_class_date;

    @Column
    private String day_of_week;

    @Column
    private double room_number;

    @Column
    private double room;

    @Column
    private String gps_coordinates;

    @Column
    private String start_time;

    @Column
    private String end_time;

    @Column
    private String campus_code;

    @Column
    private boolean hasStandardRoomDescription;

    @Column
    private int duration;

    @Column
    private char duration_code;

    @ManyToMany
    Set<Student> listOfStudents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return subject_code.equals(aClass.subject_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject_code);
    }
}
