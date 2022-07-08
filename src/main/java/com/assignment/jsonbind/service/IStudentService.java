package com.assignment.jsonbind.service;

import com.assignment.jsonbind.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    StudentDTO view (String id) throws Exception;

    List<StudentDTO> list();

    StudentDTO create(StudentDTO studentDTO) throws Exception;

    StudentDTO update(StudentDTO studentDTO) throws Exception;

    void delete(String id) throws Exception;
}
