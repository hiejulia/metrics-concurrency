package com.multithread;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;



public class CourseService {

    private CourseDao courseDAO = new CourseDao();

    //Dummy cached data used only to simulate large
    //memory allocation
    private byte[] cachedData = null;

    public synchronized List<CourseDTO> getCourses() {

        //To simulate large memory allocation,
        //let's assume we are reading serialized cache data
        //and storing it in cachedData member
        try {
            this.cachedData = generateDummyCachedData();
        } catch (IOException e) {
        }

        return courseDAO.getCourses();
    }

    private byte[] generateDummyCachedData() throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] dummyData = "Dummy cached data".getBytes();

        //write 100000 times
        for (int i = 0; i < 100000; i++)
            byteStream.write(dummyData);

        byte[] result = byteStream.toByteArray();
        byteStream.close();
        return result;
    }
}