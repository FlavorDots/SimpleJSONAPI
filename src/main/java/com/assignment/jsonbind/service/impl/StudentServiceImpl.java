package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dao.StudentRecordsRepository;
import com.assignment.jsonbind.dao.StudentRepository;
import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    StudentRecordsRepository studentRecordsRepository;

    @Override
    public StudentDTO view(String id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student ID not found!"));
        var map = new HashMap<String,String>();
        for (Class cs : student.getClass_details()) {
            map.put(cs.getSubject_code(), cs.getSubject_desc());
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudent_id(student.getStudent_id());
        studentDTO.setClassID_classDescription(map);

        return studentDTO;
    }

    @Override
    public List<StudentDTO> list() {
        return studentRepository.findAll().stream().map(std -> {
            StudentDTO studentDTO = new StudentDTO();
            var map = new HashMap<String, String>();

            for (Class cs : std.getClass_details()) {
                map.put(cs.getSubject_code(), cs.getSubject_desc());
            }
            studentDTO.setStudent_id(std.getStudent_id());
            studentDTO.setClassID_classDescription(map);

            return studentDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public StudentDTO create(StudentDTO studentDTO) throws Exception {
        Optional<Student> student = Optional.ofNullable(studentRepository.findById(studentDTO.getStudent_id())
                .orElseThrow(() -> new Exception("Student does not exist!")));
        Student std = student.get();
        var setClass = new HashSet<Class>();

        std.setStudent_id(studentDTO.getStudent_id());

        for (Map.Entry<String, String> entry : studentDTO.getClassID_classDescription().entrySet()) {
            Optional<Class> cls = Optional.ofNullable(classRepository.findById(entry.getKey())
                    .orElseThrow(() -> new Exception("Class not found")));
            setClass.add(cls.get());
        }
        std.setClass_details(setClass);

        std = studentRepository.save(std);
        studentDTO.setStudent_id(std.getStudent_id());
        return studentDTO;
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) throws Exception {
        Optional<Student> student = Optional.ofNullable(studentRepository.findById(studentDTO.getStudent_id())
                .orElseThrow(() -> new Exception("Student ID not found")));

        Student std = student.get();
        var setClass = new HashSet<Class>();

        if (studentDTO.getStudent_id() != null) std.setStudent_id(studentDTO.getStudent_id());

        if (studentDTO.getClass_details() != null){
            for (Map.Entry<String, String> entry : studentDTO.getClassID_classDescription().entrySet()) {
                Optional<Class> cls = Optional.ofNullable(classRepository.findById(entry.getKey())
                        .orElseThrow(() -> new Exception("Class not found")));
                setClass.add(cls.get());
            }
            std.setClass_details(setClass);
        }
        final Student student1 = studentRepository.save(std);
        studentDTO.setStudent_id(student1.getStudent_id());

        return studentDTO;
    }

    @Override
    public void delete(String id) throws Exception {
        Optional<Student> student =
                Optional.ofNullable(studentRepository.findById(id))
                        .orElseThrow(() -> new Exception("Student not found"));

        studentRepository.delete(student.get());
     }

}
