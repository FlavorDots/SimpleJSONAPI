package com.assignment.jsonbind.controller;


import com.assignment.jsonbind.service.SubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/subject-student")
@Slf4j
public class SubjectStudentController {

    @Autowired
    SubjectStudentService subjectStudentService;

    @GetMapping(value = "/subjects",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getSubjectIdAndCode() throws Exception {
        return new ResponseEntity(subjectStudentService.getSubjectIdAndSubjectCode(), HttpStatus.OK);
    }

    @GetMapping(value = "/{subjectCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set> getStudentIdsGivenASubjectCode(@PathVariable("subjectCode") String subjectCode) throws Exception {
        return new ResponseEntity(subjectStudentService.getUniqueStudentIds(subjectCode), HttpStatus.OK);
    }




}
