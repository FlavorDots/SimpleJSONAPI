package com.assignment.jsonbind.service.impl;

import com.assignment.jsonbind.dao.StudentRecordsRepository;
import com.assignment.jsonbind.dto.StudentRecordsDTO;
import com.assignment.jsonbind.entity.StudentRecords;
import com.assignment.jsonbind.service.IStudentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StudentRecordsImpl implements IStudentRecordsService {

    @Autowired
    StudentRecordsRepository studentRecordsRepository;

    @PostConstruct
    private void postConstruct(){
        studentRecordsRepository.deleteAll();
    }
    @Override
    public List<StudentRecords> paginatedListOfStudentRecords(Integer pageNo, Integer pageSize/*, String sortBy*/) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StudentRecords> pagedResult = studentRecordsRepository.findAll(pageable);

        if (pagedResult.hasContent()){
            return pagedResult.getContent();
        } else return null;
    }
}
