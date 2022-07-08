package com.assignment.jsonbind.service;

import com.assignment.jsonbind.dto.StudentRecordsDTO;
import com.assignment.jsonbind.entity.StudentRecords;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentRecordsService {

    List<StudentRecords> paginatedListOfStudentRecords(Integer pageNo, Integer pageSize/*, String sortBy*/);
}
