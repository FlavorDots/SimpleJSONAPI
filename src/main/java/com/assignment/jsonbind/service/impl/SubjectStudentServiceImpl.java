package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.ClassRepository;
;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.dto.SubjectStudentDTO;
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

    //Please DELETE this
//    @Override
//    public Map<String, String> getSubjectIdAndSubjectCode() {
//
//        Map<String, String> mapIdCode = new HashMap<>();
//        for (Class cc : classRepository.findAll()) {
//            mapIdCode.put(cc.getSubject_code(), cc.getSubject_desc());
//        }
//
//        return mapIdCode;
//    }

    @Override
    public SubjectStudentDTO allSubjects() {
        List<Class> listOfClassDTOS = classRepository.findAll();
        List<ClassDTO> sam = new ArrayList<>();
        SubjectStudentDTO studentDTO = new SubjectStudentDTO();
        for (Class ff : listOfClassDTOS){
            ClassDTO clsDTO = new ClassDTO();
            clsDTO.setSubject_code(ff.getSubject_code());
            clsDTO.setSubject_desc(ff.getSubject_desc());
            sam.add(clsDTO);
        }
        studentDTO.setSubjects(sam);

        return studentDTO;
    }

//    @Override
//    public Set<String> getUniqueStudentIds(String subjectCode) throws Exception {
//        Optional<Class> listOfUniqueStudentIds = classRepository.findById(subjectCode);
//        Class cls = new Class();
//        Set<String> listIds = new TreeSet<>();
//
//        if (listOfUniqueStudentIds.isPresent()) cls = listOfUniqueStudentIds.get();
//        else throw new Exception("Class ID " + subjectCode +" not found!");
//
//        for (Student std : cls.getListOfStudents()){
//            listIds.add(std.getStudent_id());
//        }
//        return listIds;
//
//    }

    public ClassDTO viewStudentsEnrolled(String subjectCode) throws Exception {
        Optional<Class> listOfUniqueStudentIds = classRepository.findById(subjectCode);
        Class cls = new Class();
        ClassDTO classDTO = new ClassDTO();
        List<SubjectStudentDTO> studentDTO = new ArrayList<>();

        if (listOfUniqueStudentIds.isPresent()) cls = listOfUniqueStudentIds.get();
        else throw new Exception("Class ID " + subjectCode +" not found!");

        for (Student std : cls.getListOfStudents()){
            SubjectStudentDTO studentDTO1 = new SubjectStudentDTO();
            studentDTO1.setStudent_id(std.getStudent_id());
            studentDTO.add(studentDTO1);
        }

        classDTO.setSubject_code(cls.getSubject_code());
        classDTO.setSubject_desc(cls.getSubject_desc());
        classDTO.setStudent_ids(studentDTO);

        return classDTO;
    }
}
