package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.config.Bean;
import com.assignment.jsonbind.dto.ClassDetailsDTO;
import com.assignment.jsonbind.dto.SubjectIDSubjectCodeDTO;
import com.assignment.jsonbind.service.SubjectStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class SubjectStudentServiceImpl implements SubjectStudentService {

    @Autowired
    Bean bean;

    @Override
    public Map<String, String> getSubjectIdAndSubjectCode() throws Exception {
        		Map<String, String> subjectIDAndCode = new HashMap<>();

		for (SubjectIDSubjectCodeDTO subjID : bean.jsonFile()){
			List<ClassDetailsDTO> classDetailsDTOS= subjID.getClass_details();
			for (ClassDetailsDTO classDTOS : classDetailsDTOS){
				subjectIDAndCode.put(classDTOS.getSubject_code(),classDTOS.getSubject_desc());
			}
		}
        return subjectIDAndCode;
    }

    @Override
    public Set<String> getUniqueStudentIds(String subjectCode) throws Exception {
        Set<String> listOfStudentIds = new HashSet<>();

        for (SubjectIDSubjectCodeDTO subjID : bean.jsonFile()){
            List<ClassDetailsDTO> classDetailsDTOS= subjID.getClass_details();
            for (ClassDetailsDTO classDTOS : classDetailsDTOS){
                if (classDTOS.getSubject_code().equals(subjectCode)){
                    listOfStudentIds.add(subjID.getStudent_id());
                }
            }
        }
        return listOfStudentIds;
    }
}
