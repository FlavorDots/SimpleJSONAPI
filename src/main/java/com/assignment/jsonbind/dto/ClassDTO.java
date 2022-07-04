package com.assignment.jsonbind.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ClassDTO {

    private String subject_code;

    private String subject_desc;

    private LocalDate week_start_date;

    private LocalDate week_end_date;

    private LocalDate exact_class_date;

    private String day_of_week;

    private double room_number;

    private double room;

    private Long gps_coordinates;

    private String start_time;

    private String end_time;

    private String campus_code;

    private Boolean hasStandardRoomDescription;

    private Integer duration;

    private Character duration_code;




}
