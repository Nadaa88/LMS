import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class StudentCoursedetails {// JSON data that represents the courses and students
    private static Map<Integer, List<Integer>> courses = new HashMap<>();

    public static void main(String[] args) {
        // Populate the courses data
        List<Integer> student1Courses = new ArrayList<>();
        student1Courses.add(1);
        student1Courses.add(2);
        student1Courses.add(3);
        student1Courses.add(4);
        courses.put(1, student1Courses);

        List<Integer> student2Courses = new ArrayList<>();
        student2Courses.add(2);
        student2Courses.add(4);
        student2Courses.add(6);
        courses.put(2, student2Courses);

        List<Integer> student3Courses = new ArrayList<>();
        student3Courses.add(1);
        student3Courses.add(3);
        student3Courses.add(5);
        courses.put(3, student3Courses);

        // Get the student id from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student id: ");
        int studentId = scanner.nextInt();

        // Get the student courses
        List<Integer> studentCourses = courses.get(studentId);

        // Print the student details
        System.out.println("====================================================================================");
        System.out.println("Student Details page");
        System.out.println("====================================================================================");
        System.out.println("Name: Malcolm Barnes\t\tGrade:9\t\tEmail:velit.aliquam@outlook.couk");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.print("Enrolled courses.");
        if (studentCourses == null) {
            System.out.println("This student hasn't enrolled in any courses");
        } else {
            for (Integer courseId : studentCourses) {
                System.out.println("- " + courseId + "-" + " 1, Algorithms, Scott, Austin C., 8 weeks, 2H, Hall1");
            }
        }
        System.out.println("------------------------------------------------------------------------------------");

        // Get the student courses
        List<Integer> studentCourse = courses.get(studentId);

        if (studentCourses == null) {


            scanner.close();
        }
    }
}
