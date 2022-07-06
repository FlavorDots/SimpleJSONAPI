package com.assignment.jsonbind;

import com.assignment.jsonbind.config.Bean;
import com.assignment.jsonbind.service.SubjectStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    SubjectStudentService subjectStudentService;

    @Autowired
    Bean bean;

    @Test
    public void getSubjectIdAndCodeShouldReturnProperResponse()
    throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/subject-student/subjects", String.class)).contains(
                "ACC2CAD", "ACC5TAX", "IBU5HRM","BUS3ENT", "MGT5IPM", "BUS2SUS", "MGT2HRM", "CSE2NEF", "FIN2BFI", "MGT3LWM",
                "MGT5STR", "MGT5MPT","MGT3RPM","ACC5FAS","ACC3AFA","FIN5FMA","MAT1DM","ACC5MCR","CSE1IS","BUS5POE","ACC5AAI",
                "ACC1AIS","CSE1IOO","BUS5IAF","CSE2DBF","BUS5SMM","ACC5AAS","CSE1OOF","MP5SS",
                "Cost Accounting and Decision Making", "Taxation", "Human Resource Management in Global Economy", "Entrepreneurship",
                "International Project Management", "Information System Development", "International Marketing", "Corporate Finance");
    }

//    @Test
//    public void getStudentIdsGivenASubjectCodeShouldReturnProperResponse()
//    throws Exception{
//        String subjectCode = "ACC3TAX";
//
//        String[] ss =
//                subjectStudentService.getUniqueStudentIds(subjectCode)
//                                .toArray(new String[0]);
//
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/subject-student/" + subjectCode, String.class))
//                .contains(ss);
//    }
}
