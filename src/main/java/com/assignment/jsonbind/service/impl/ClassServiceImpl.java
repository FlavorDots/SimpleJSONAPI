package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    ClassRepository classRepository;

    @Override
    public ClassDTO view(String id) throws Exception {
        Class cls = classRepository.findById(id)
                .orElseThrow(() -> new Exception("Class does not exist!"));

        ClassDTO classDTO = new ClassDTO();

        classDTO.setSubject_code(cls.getSubject_code());
        classDTO.setSubject_desc(cls.getSubject_desc());
        classDTO.setWeek_start_date(cls.getWeek_start_date());
        classDTO.setWeek_end_date(cls.getWeek_end_date());
        classDTO.setExact_class_date(cls.getExact_class_date());
        classDTO.setDay_of_week(cls.getDay_of_week());
        classDTO.setRoom_number(cls.getRoom_number());
        classDTO.setRoom(cls.getRoom());
        classDTO.setGps_coordinates(cls.getGps_coordinates());
        classDTO.setStart_time(cls.getStart_time());
        classDTO.setEnd_time(cls.getEnd_time());
        classDTO.setCampus_code(cls.getCampus_code());
        classDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
        classDTO.setDuration(cls.getDuration());
        classDTO.setDuration_code(cls.getDuration_code());

        return classDTO;
    }

    @Override
    public List<ClassDTO> list() {
        return classRepository.findAll().stream().map(cls ->{
            ClassDTO classDTO = new ClassDTO();

            classDTO.setSubject_code(cls.getSubject_code());
            classDTO.setSubject_desc(cls.getSubject_desc());
            classDTO.setWeek_start_date(cls.getWeek_start_date());
            classDTO.setWeek_end_date(cls.getWeek_end_date());
            classDTO.setExact_class_date(cls.getExact_class_date());
            classDTO.setDay_of_week(cls.getDay_of_week());
            classDTO.setRoom_number(cls.getRoom_number());
            classDTO.setRoom(cls.getRoom());
            classDTO.setGps_coordinates(cls.getGps_coordinates());
            classDTO.setStart_time(cls.getStart_time());
            classDTO.setEnd_time(cls.getEnd_time());
            classDTO.setCampus_code(cls.getCampus_code());
            classDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
            classDTO.setDuration(cls.getDuration());
            classDTO.setDuration_code(cls.getDuration_code());
            return classDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public ClassDTO create(ClassDTO classDTO) throws Exception {
        return null;
    }

    @Override
    public ClassDTO update(ClassDTO classDTO) throws Exception {
        return null;
    }

    @Override
    public void delete(String id) throws Exception {

    }
}
