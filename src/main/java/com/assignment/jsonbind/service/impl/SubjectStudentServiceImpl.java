package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dao.StudentRepository;
;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.service.ISubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class SubjectStudentServiceImpl implements ISubjectStudentService {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Map<String, String> getSubjectIdAndSubjectCode() throws Exception {

        Map<String, String> mapIdCode = new HashMap<>();
        for (Class cc : classRepository.findAll()) {
            mapIdCode.put(cc.getSubject_code(), cc.getSubject_desc());
        }

        return mapIdCode;
    }

    @Override
    public Set<String> getUniqueStudentIds(String subjectCode) throws Exception {
        Optional<Class> listOfUniqueStudentIds = classRepository.findById(subjectCode);
        Class cls = new Class();
        Set<String> listIds = new HashSet<>();

        if (listOfUniqueStudentIds.isPresent()) cls = listOfUniqueStudentIds.get();
        else throw new Exception("Class ID " + subjectCode +" not found!");

        for (Student std : cls.getListOfStudents()){
            listIds.add(std.getStudent_id());
        }

        return listIds;

    }


}
