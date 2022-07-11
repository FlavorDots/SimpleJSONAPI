package com.assignment.jsonbind.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClassDTO {

    private String subject_code;

    private String subject_desc;

    private Date week_start_date;

    private Date week_end_date;

    private Date exact_class_date;

    private String day_of_week;

    private double room_number;

    private double room;

    private String gps_coordinates;

    private String start_time;

    private String end_time;

    private String campus_code;

    private boolean hasStandardRoomDescription;

    private int duration;

    private char duration_code;

}
