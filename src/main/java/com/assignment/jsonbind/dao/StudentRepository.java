package com.assignment.jsonbind.dao;

import com.assignment.jsonbind.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
