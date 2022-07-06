package com.assignment.jsonbind.dao;

import com.assignment.jsonbind.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(value = "SELECT * FROM Student e WHERE e.class_details.subject_code = :sc",
    nativeQuery = true)
    Page<Student> getAllUniqueStudentId(@Param("sc") String subjectcode, Pageable pageable);
}
