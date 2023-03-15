package Admin;

import java.util.ArrayList;

public class Courses {
        private int id;
        private String name;
        private String instructor;
        private String courseduration;
        private String Coursetime;
        private String Location;
        private ArrayList<Student> studentsEnrolled;

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


        public void setinstructor(String instructor) {
            this.instructor = instructor;
        }

        public String getinstructor() {
            return this.instructor;
        }

        public void setcourseduration(String courseduration) {
            this.courseduration = courseduration;
        }

        public String getcourseduration() {
            return this.courseduration;
        }

        public void setCoursetime(String Coursetime) {
            this.Coursetime = Coursetime;
        }

        public String getCoursetime() {

            return this.Coursetime;
        }

        public void setLocation(String Location) {

            this.Location = Location;
        }

        public String getLocation() {

            return this.Location;
        }

        public ArrayList<Student> getStudentsEnrolled() {
            return this.studentsEnrolled;
        }
    }


