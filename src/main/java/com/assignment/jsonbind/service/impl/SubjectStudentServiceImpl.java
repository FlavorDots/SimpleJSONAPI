package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.config.Bean;
import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dao.StudentRepository;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.dto.ClassDetailsDTO;
import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.service.SubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class SubjectStudentServiceImpl implements SubjectStudentService {

    @Autowired
    Bean bean;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Map<String, String> getSubjectIdAndSubjectCode() throws Exception {

        Map<String, String> mapIdCode = new HashMap<>();
        for (Class cc: classRepository.findAll()) {
            mapIdCode.put(cc.getSubject_code(), cc.getSubject_desc());
        }
        classRepository.findAll();

        return mapIdCode;
    }

    @Override
    public Set<String> getUniqueStudentIds(String subjectCode) throws Exception {

        List<Student> ff = studentRepository.findAll();

//        return studentRepository.findUniqueStudentIds(subjectCode);

        return null;

//        for (StudentDTO subjID : bean.jsonFile()){
//            Set<ClassDTO> classDetailsDTOS= subjID.getClass_details();
//            for (ClassDTO classDTOS : classDetailsDTOS){
//                if (classDTOS.getSubject_code().equals(subjectCode)){
//                    listOfStudentIds.add(subjID);
//                }
//            }
//        }
    }
}
