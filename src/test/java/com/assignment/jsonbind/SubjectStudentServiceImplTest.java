package com.assignment.jsonbind;

import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import com.assignment.jsonbind.service.impl.SubjectStudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SubjectStudentServiceImplTest {

    @InjectMocks
    SubjectStudentServiceImpl subjectStudentService;

    @Mock
    ClassRepository classRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    final void testViewStudentsEnrolled() throws Exception {
        Class cls = new Class();
        cls.setSubject_code("ADDFCC");
        cls.setSubject_desc("Math");
        cls.setWeek_start_date(new Date(2323223232L));
        cls.setWeek_end_date(new Date(2323223232L));
        cls.setExact_class_date(new Date(2323223232L));
        cls.setDay_of_week("12-24-2020");
        cls.setRoom_number(12);
        cls.setRoom(11);
        cls.setGps_coordinates("32n32j132");
        cls.setStart_time("12:00");
        cls.setEnd_time("1:00");
        cls.setCampus_code("aa1");
        cls.setDuration('A');
        cls.setListOfStudents(new HashSet<>());

        when(classRepository.findById(anyString())).thenReturn(Optional.of(cls));

        ClassDTO classDTO = subjectStudentService.viewStudentsEnrolled("111AAAAX");

        assertNotNull(classDTO);
        assertEquals("ADDFCC", classDTO.getSubject_code());
    }

}
