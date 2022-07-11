package com.assignment.jsonbind.service;

import com.assignment.jsonbind.dto.ClassDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ISubjectStudentService {

    Map<String, String> getSubjectIdAndSubjectCode() throws Exception;
    List<ClassDTO> mappingYARN() throws Exception;


    Set<String> getUniqueStudentIds(String subjectCode) throws Exception;
}
