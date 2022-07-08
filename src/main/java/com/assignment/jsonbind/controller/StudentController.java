package com.assignment.jsonbind.controller;

import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.entity.StudentRecords;
import com.assignment.jsonbind.service.IStudentRecordsService;
import com.assignment.jsonbind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @Autowired
    IStudentRecordsService studentRecordsService;

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(
            @PathVariable("studentId") String studentId
    ) throws Exception {
        return new ResponseEntity(iStudentService.view(studentId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity(iStudentService.list(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<StudentRecords>> getPaginatedStudents(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize)
    {
        List<StudentRecords> studentRecords = studentRecordsService.paginatedListOfStudentRecords(pageNo,pageSize);

        return new ResponseEntity(studentRecords, HttpStatus.OK);
    }
}
