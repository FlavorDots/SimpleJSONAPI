package com.assignment.jsonbind.service;

import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.dto.SubjectStudentDTO;

public interface ISubjectStudentService {

//    Map<String, String> getSubjectIdAndSubjectCode() throws Exception;

    SubjectStudentDTO allSubjects() throws Exception;

    ClassDTO viewStudentsEnrolled(String subjectCode) throws Exception;
//    Set<String> getUniqueStudentIds(String subjectCode) throws Exception;
}
