package com.assignment.jsonbind.config;

import com.assignment.jsonbind.dto.SubjectIDSubjectCodeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;
import java.util.List;

@Configuration
public class Bean {

    @org.springframework.context.annotation.Bean
    public List<SubjectIDSubjectCodeDTO> jsonFile() throws Exception{
        return new ObjectMapper().readValue(
                Paths.get("src/main/resources/json/output.json").toFile(), new TypeReference<>() {}

        );
    }
}
