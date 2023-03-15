import Admin.Courses;
import Admin.CSV_reader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CourseseReader {public ArrayList<Courses> readData() {
    CSV_reader courseReader = new CSV_reader("E:\\New folder\\testing\\front end testing\\LMS.Project\\LMS\\src\\Course-data-1.csv");
    ArrayList<String> courses = new ArrayList<String>();

    courses = (ArrayList<String>) courseReader.readAll();

    ArrayList<Courses> CoursesList = new ArrayList<Courses>();

    for (int i = 1; i < courses.size(); i++) {
        String CourseData = courses.get(i);
        Courses Courses = new Courses();
        String[] data = CourseData.split(",");
        Courses.setId(parseInt(data[0]));
        Courses.setName(data[1]);
        Courses.setinstructor(data[2]);
        Courses.setcourseduration(data[3]);
        Courses.setCoursetime(data[4]);
        Courses.setLocation(data[5]);
        CoursesList.add(Courses);
    }
    return CoursesList;
}

    public void formatAndPrint(ArrayList<Courses> courses) {
        //prints the list objects in tabular format
        System.out.printf("%5s %25s %22s %20s %15s %20s", "id", "Course name", "Instructor", "course duration", "course time", "location");
        System.out.println();
        //iterates over the list
        for(Courses course: courses)
        {
            System.out.format("%5s %30s %15s %20s %15s %15s", course.getId(), course.getName(), course.getinstructor(), course.getcourseduration(), course.getCoursetime(), course.getLocation());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

}