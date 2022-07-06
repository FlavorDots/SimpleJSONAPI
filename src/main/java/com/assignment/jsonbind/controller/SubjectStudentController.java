package com.assignment.jsonbind.controller;


import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.service.SubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subject-student")
@Slf4j
public class SubjectStudentController {

    @Autowired
    SubjectStudentService subjectStudentService;

//    @GetMapping(value = "/subjects",
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Map> getSubjectIdAndCode() throws Exception {
//        return new ResponseEntity(subjectStudentService.getSubjectIdAndSubjectCode(), HttpStatus.OK);
//    }

    @GetMapping(value = "/subjects",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> getSubjectIdAndCode() throws Exception {
        return subjectStudentService.getSubjectIdAndSubjectCode();
    }

//    @GetMapping(value = "/{subjectCode}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<String>> getStudentIdsGivenASubjectCode(@PathVariable("subjectCode") String subjectCode) throws Exception {
//        return new ResponseEntity(subjectStudentService.getUniqueStudentIds(subjectCode), HttpStatus.OK);
//    }
    @GetMapping(value = "/{subjectCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStudentIdsGivenASubjectCode(@PathVariable("subjectCode") String subjectCode) throws Exception {
        List<String> studentLists = new ArrayList<>();

        for (Student student: subjectStudentService.getUniqueStudentIds(subjectCode)) {
            studentLists.add(student.getStudent_id());
        }

        return studentLists;
    }
}
