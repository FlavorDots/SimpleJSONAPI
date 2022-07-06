package com.assignment.jsonbind;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JsonBindApplication implements CommandLineRunner {

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

/*		List<Student> student = studentRepository.findAll();
		List<Class> classes = classRepository.findAll();

		for (Class cls : classes){
			Set<Student> setsOfStudents = new HashSet<>();
			for (Student studs : student){
				for (Class deets : studs.getClass_details()){
					if (cls.getSubject_code().equals(deets.getSubject_code())){
						setsOfStudents.add(studs);
					}
				}
			}
			Optional<Class> cl = classRepository.findById(cls.getSubject_code());
			Class enterHere = new Class();
			if (cl.isEmpty()) throw new Exception("Not Found");
			else {
				enterHere = cl.get();
			}
			enterHere.setListOfStudents(setsOfStudents);
			classRepository.save(enterHere);
		}*/
	}

}
