package com.assignment.jsonbind;

import com.assignment.jsonbind.config.Bean;
import com.assignment.jsonbind.dao.ClassRepository;
import com.assignment.jsonbind.dao.StudentRepository;
import com.assignment.jsonbind.dto.ClassDTO;
import com.assignment.jsonbind.dto.ClassDetailsDTO;
import com.assignment.jsonbind.dto.StudentDTO;
import com.assignment.jsonbind.entity.Class;
import com.assignment.jsonbind.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@SpringBootApplication
@EnableJpaRepositories(
		basePackages = {"com.assignment.jsonbind.entity"},
		basePackageClasses = {ClassRepository.class,
				StudentRepository.class}
)
@Slf4j
public class JsonBindApplication implements CommandLineRunner {

	@Autowired(required = true)
	public Bean bean;

	@Autowired(required = true)
	public ClassRepository classRepository;

	@Autowired
	public StudentRepository studentRepository;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JsonBindApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		for (StudentDTO subjID : bean.jsonFile()){
//			Student student = new Student();
//			student.setStudent_id(subjID.getStudent_id());
//			Set<Class> dd = new HashSet<>();
//
//			for (Class c2 : subjID.getClass_details()){
//				Optional<Class> d = classRepository.findById(c2.getSubject_code());
//				if (dd.contains(d.get())) continue;
//				else {dd.add(d.get());
//				}
//			}
//			student.setClass_details(dd);
//						studentRepository.save(student);
//		}

//	: Used for populating the class table

			for (StudentDTO subjID : bean.jsonFile()){
			Set<Class> classDetailsDTOS= subjID.getClass_details();
			for (Class classDTOS : classDetailsDTOS){
				Optional<Class> findClass = classRepository.findById(classDTOS.getSubject_code());
				Set<Student> stud = new HashSet<>();
				Optional<Student> sd = studentRepository.findById(subjID.getStudent_id());
				stud.add(sd.get());
				Class found = findClass.get();
				found.getListOfStudents().add(sd.get());
				final  Class cc = classRepository.save(found);
				cc.setSubject_code(classDTOS.getSubject_code());
			}
		}
	}

}
