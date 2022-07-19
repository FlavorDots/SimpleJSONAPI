package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.StudentRecordsRepository;
import com.assignment.jsonbind.dao.StudentRepository;
import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.dto.StudentRecordsDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.entity.StudentRecords;
import com.assignment.jsonbind.service.IStudentRecordsService;
import com.assignment.jsonbind.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentRecordsImpl implements IStudentRecordsService {

    @Autowired
    StudentRecordsRepository studentRecordsRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentRecords> paginatedListOfStudentRecords(Integer pageNo, Integer pageSize, String sortBy) {
        persistRecords();
        var pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        var pagedResult = studentRecordsRepository.findAll(pageable);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else return null;
    }

    public void persistRecords(){
        studentRecordsRepository.deleteAll();

        studentRepository.findAll().stream().map(std -> {
            var studentRecords = new StudentRecords();
            var setOfClassNames = new HashSet<String>();

            studentRecords.setStudentIdRecord(std.getStudent_id());
            for (var ccs : std.getClass_details()){
                setOfClassNames.add(ccs.getSubject_desc());
            }
            var lists = new ArrayList<String>(setOfClassNames);

            studentRecords.setClass_details_record(lists);
            studentRecordsRepository.save(studentRecords);
            return studentRecords;
        }).collect(Collectors.toList());
    }

}
