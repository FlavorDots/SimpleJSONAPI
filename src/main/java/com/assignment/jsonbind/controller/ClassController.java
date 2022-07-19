package com.assignment.jsonbind.controller;

import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    IClassService iClassService;

    @GetMapping("/{classId}")
    public ResponseEntity<Class> getClass(@PathVariable("classId")String classId ) throws Exception {
        return new ResponseEntity(iClassService.view(classId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Class> getAllClass() {
        return new ResponseEntity(iClassService.list(), HttpStatus.OK);
    }
}
