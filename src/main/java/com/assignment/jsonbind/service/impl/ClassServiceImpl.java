package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Class> cls = classRepository.findById(classDTO.getSubject_code());

        if (cls.isPresent()) {
            throw new Exception("Class already exists");
        }
        else {
            Class cs = new Class();

            cs.setSubject_code(classDTO.getSubject_code());
            cs.setSubject_desc(classDTO.getSubject_desc());
            cs.setWeek_start_date(classDTO.getWeek_start_date());
            cs.setWeek_end_date(classDTO.getWeek_end_date());
            cs.setExact_class_date(classDTO.getExact_class_date());
            cs.setDay_of_week(classDTO.getDay_of_week());
            cs.setRoom_number(classDTO.getRoom_number());
            cs.setRoom(classDTO.getRoom());
            cs.setGps_coordinates(classDTO.getGps_coordinates());
            cs.setStart_time(classDTO.getStart_time());
            cs.setEnd_time(classDTO.getEnd_time());
            cs.setCampus_code(classDTO.getCampus_code());
            cs.setHasStandardRoomDescription(classDTO.isHasStandardRoomDescription());
            cs.setDuration(classDTO.getDuration());
            cs.setDuration_code(classDTO.getDuration_code());

            cs = classRepository.save(cs);
            classDTO.setSubject_code(cs.getSubject_code());
        }
        return classDTO;
    }

    @Override
    public ClassDTO update(ClassDTO classDTO) throws Exception {
        Optional<Class> cls = classRepository.findById(classDTO.getSubject_code());

        if (cls.isEmpty()) throw new Exception("Class not found!");
        else {
            Class cs = cls.get();

            if (classDTO.getSubject_code() != null) cs.setSubject_code(classDTO.getSubject_code());
            if (classDTO.getSubject_desc() != null) cs.setSubject_desc(classDTO.getSubject_desc());
            if (classDTO.getWeek_start_date() != null) cs.setWeek_start_date(classDTO.getWeek_start_date());
            if (classDTO.getWeek_end_date() != null) cs.setWeek_end_date(classDTO.getWeek_end_date());
            if (classDTO.getExact_class_date() != null) cs.setExact_class_date(classDTO.getExact_class_date());
            if (classDTO.getDay_of_week() != null) cs.setDay_of_week(classDTO.getDay_of_week());
            if (classDTO.getRoom_number() != 0.0) cs.setRoom_number(classDTO.getRoom_number());
            if (classDTO.getRoom() != 0.0) cs.setRoom(classDTO.getRoom());
            if (classDTO.getGps_coordinates() != null) cs.setGps_coordinates(classDTO.getGps_coordinates());
            if (classDTO.getStart_time() != null) cs.setStart_time(classDTO.getStart_time());
            if (classDTO.getEnd_time() != null) cs.setEnd_time(classDTO.getEnd_time());
            if (classDTO.getCampus_code() != null) cs.setCampus_code(classDTO.getCampus_code());
            if (classDTO.isHasStandardRoomDescription() != false) cs.setHasStandardRoomDescription(classDTO.isHasStandardRoomDescription());
            if (classDTO.getDuration() != 0) cs.setDuration(classDTO.getDuration());
            if (classDTO.getDuration_code() != ' ') cs.setDuration_code(classDTO.getDuration_code());

            final Class classUpdated = classRepository.save(cs);
            classDTO.setSubject_code(classUpdated.getSubject_code());
            return classDTO;
        }
    }

    @Override
    public void delete(String id) throws Exception {
        Optional<Class> cls = classRepository.findById(id);

        if (cls.isPresent()) classRepository.delete(cls.get());
        else throw new Exception("Class not found!");
    }
}
