package com.assignment.jsonbind.service;


import com.assignment.jsonbind.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SubjectStudentService {

    Map<String, String> getSubjectIdAndSubjectCode() throws Exception;

    //    Set<String> getUniqueStudentIds(String subjectCode) throws Exception;
    List<Student> getUniqueStudentIds(String subjectCode) throws Exception;
}
