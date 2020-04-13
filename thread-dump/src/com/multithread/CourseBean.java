package com.multithread;


import java.util.List;

public class CourseBean {
    private CourseService courseService = new CourseService();

    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }
}