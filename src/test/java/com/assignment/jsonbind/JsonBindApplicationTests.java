package com.assignment.jsonbind;

import com.assignment.jsonbind.dto.SubjectIDSubjectCodeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JsonBindApplicationTests {

	@Test
	void contextLoads() {
	}

/*	@Test
	void serializeSubjectIDSubjectCode() throws JsonProcessingException{
		SubjectIDSubjectCodeDTO dto = new SubjectIDSubjectCodeDTO();
		dto.setSubjectCode("AX123");
		dto.setSubjectDescription("Math");
		Map<String, String> pair = new HashMap<>();
		pair.put(dto.getSubjectCode(), dto.getSubjectDescription());
		dto.setCode_description(pair);

		String result = new ObjectMapper().writeValueAsString(dto);
	}*/

}
