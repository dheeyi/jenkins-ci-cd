package com.jenkins_ci_cd.jenkins_ci_cd.Controller;

import com.jenkins_ci_cd.jenkins_ci_cd.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/nameCourse")
    public ResponseEntity<Map<String, String>> nameApp() {
        String DEFAULT_COURSE = "Curso: CI/CD con Jenkins y CircleCI";
        String courseName = courseService.getNameCourse(DEFAULT_COURSE);

        Map<String, String> response = new HashMap<>();
        response.put("course", courseName);
        response.put("status", "success");
        response.put("year", "2024");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}