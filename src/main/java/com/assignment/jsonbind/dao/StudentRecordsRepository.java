package com.assignment.jsonbind.dao;

import com.assignment.jsonbind.entity.StudentRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRecordsRepository extends JpaRepository<StudentRecords, String> {
}
