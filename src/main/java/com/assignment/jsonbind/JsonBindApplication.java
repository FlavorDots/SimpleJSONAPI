package com.assignment.jsonbind;

import com.assignment.jsonbind.dto.ClassDetailsDTO;
import com.assignment.jsonbind.dto.SubjectIDSubjectCodeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@SpringBootApplication
public class JsonBindApplication implements CommandLineRunner {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JsonBindApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
/*
		Car car = new Car("yellow", "renault");
		objectMapper.writeValue(new File
				("src/main/resources/json/car.json"), car);
		String carAsString = objectMapper.writeValueAsString(car);
		System.out.println(carAsString);

		List<Car> cars = new ObjectMapper().readValue(Paths.get("src/main/resources/json/car.json").toFile(), new TypeReference<>() {});
		cars.forEach(System.out::println);

		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String, Object> map
				= objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
		System.out.println(map);

		List<SubjectIDSubjectCodeDTO> listOfSubjID =
				new ObjectMapper().readValue(
						Paths.get("src/main/resources/json/output.json").toFile(), new TypeReference<>() {}
				);
*/

		//#1
		Map<String, String> subjectIDAndCode = new HashMap<>();

		for (SubjectIDSubjectCodeDTO subjID : listOfSubjID){
			List<ClassDetailsDTO> classDetailsDTOS= subjID.getClass_details();
			for (ClassDetailsDTO classDTOS : classDetailsDTOS){
				subjectIDAndCode.put(classDTOS.getSubject_code(),classDTOS.getSubject_desc());
			}
		}

		subjectIDAndCode.forEach((k,v) -> System.out.println(k + " " + v));

		//#2
		String subjectCode = "ACC3AFA";
		Set<String> listOfStudentIds = new HashSet<>();

		for (SubjectIDSubjectCodeDTO subjID : listOfSubjID){
			List<ClassDetailsDTO> classDetailsDTOS= subjID.getClass_details();
			for (ClassDetailsDTO classDTOS : classDetailsDTOS){
				if (classDTOS.getSubject_code().equals(subjectCode)){
					listOfStudentIds.add(subjID.getStudent_id());
				}
			}
		}

		System.out.println("List of Student IDs for Subject Code: " + subjectCode);
		listOfStudentIds.forEach(System.out::println);



	}
}
