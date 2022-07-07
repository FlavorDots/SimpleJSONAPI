package com.assignment.jsonbind.controller;


import com.assignment.jsonbind.service.ISubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subject-student")
@Slf4j
public class SubjectStudentController {

    @Autowired
    ISubjectStudentService ISubjectStudentService;

    @GetMapping(value = "/subjects",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getSubjectIdAndCode() throws Exception {
        return new ResponseEntity(ISubjectStudentService.getSubjectIdAndSubjectCode(), HttpStatus.OK);
    }

    @GetMapping(value = "/{subjectCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getStudentIdsGivenASubjectCode(@PathVariable("subjectCode") String subjectCode) throws Exception {
        return new ResponseEntity(ISubjectStudentService.getUniqueStudentIds(subjectCode), HttpStatus.OK);
    }


}
