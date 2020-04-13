package com.multithread;


import java.util.ArrayList;
import java.util.List;



public class CourseDao {

    public List<CourseDTO> getCourses() {

        //We will just simulate a long running database operation
        try {
            Thread.sleep(10000); //wait 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}