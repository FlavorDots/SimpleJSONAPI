package com.assignment.jsonbind.service;

import com.assignment.jsonbind.dto.ClassDTO;

import java.util.List;

public interface IClassService {

    ClassDTO view (String id) throws Exception;

    List<ClassDTO>  list();

    ClassDTO create(ClassDTO classDTO) throws Exception;

    ClassDTO update(ClassDTO classDTO) throws Exception;

    void delete(String id) throws Exception;

}
