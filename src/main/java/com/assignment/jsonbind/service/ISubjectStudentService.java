package com.assignment.jsonbind.service;

import java.util.Map;
import java.util.Set;

public interface ISubjectStudentService {

    Map<String, String> getSubjectIdAndSubjectCode() throws Exception;

    Set<String> getUniqueStudentIds(String subjectCode) throws Exception;
}
