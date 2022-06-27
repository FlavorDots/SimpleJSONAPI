package com.assignment.jsonbind.service;

import java.util.Map;
import java.util.Set;

public interface SubjectStudentService {

    Map<String, String> getSubjectIdAndSubjectCode() throws Exception;

    Set<String> getUniqueStudentIds(String subjectCode) throws Exception;
}
