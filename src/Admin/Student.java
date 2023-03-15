package Admin;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;


public class Student {
    private int id;
    private String name;
    private int grade;
    private String email;
    private String address;
    private String region;
    private String country;
    private List<Integer> courses = new ArrayList<Integer>();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public List<Integer> getCoursesEnrolled() {
        return this.courses;
    }

//    private JsonArray readJson(String path) {
//        String reader = null;
//        try {
//          reader = new String(Files.readAllBytes(Paths.get(path)));
//        } catch(IOException ie) {
//          ie.printStackTrace();
//        }
//
//        JsonArray parser = null;
//        try {
//          parser = (JsonArray) Jsoner.deserialize(reader);
//        } catch(JsonException ie) {
//          throw new RuntimeException(ie);
//        }
//
//        return parser;
//    }
//
//    private void writeJson(String path) {
//        JsonArray js = new JsonArray();
//
//        String jsonText = Jsoner.serialize(js);
//
//        try {
//            Files.write(Paths.get(path), jsonText.getBytes());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public void enrollInCourse(int courseId) throws Exception {

        // check if student
        if (this.courses.size() == 6) throw new Exception("Student can't enroll in more than 6 courses!");

        // check if student already enrolled in that course before
        for (Integer course: this.courses) {
            if (course == courseId) {
                throw new Exception("Student already enrolled in that course!");
            }
        }

        // enroll student
        this.courses.add(courseId);

        // update json file
        // JsonArray studentsJsonData = this.readJson("/Users/ahmed.elsaid/Desktop/LMS/src/Student course details.json");

    }

    public void unEnrollFromCourse(int courseId) throws Exception {

        if (this.courses.size() <= 1) {
            throw new Exception("Student can't unenroll from that course!");
        }

        this.courses.remove(Integer.valueOf(courseId));

        // update json file

    }

}