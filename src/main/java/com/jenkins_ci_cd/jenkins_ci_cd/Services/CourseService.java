package com.jenkins_ci_cd.jenkins_ci_cd.Services;

import org.springframework.stereotype.Service;

@Service
public class CourseService implements CourseInterface{
    @Override
    public String getNameCourse(String nameCourse) {
        return nameCourse;
    }
}
