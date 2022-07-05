package com.assignment.jsonbind.dao;

import com.assignment.jsonbind.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

//    @Query("SELECT student_student_id FROM student_classes_mapping student_student_id WHERE student_student_id.class_subject_code = ?1")
//    Set<String> findUniqueStudentIds(String subjectCode);
}
