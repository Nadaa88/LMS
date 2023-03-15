import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Studentdetails {
    private static Map<Integer, int[]> studentCourses = new HashMap<>();

    public static void main(String[] args) {
        // Initialize the data for student courses
        studentCourses.put(1, new int[]{1, 2, 3, 4});
        studentCourses.put(2, new int[]{2, 4, 6});
        studentCourses.put(3, new int[]{1, 3, 5});

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the student id: ");
        int id = sc.nextInt();

        if (studentCourses.containsKey(id)) {
            int[] courses = studentCourses.get(id);
            System.out.println("====================================================================================");
            System.out.println("Student Details page");
            System.out.println("====================================================================================");
            System.out.println("Name: Malcolm Barnes         Grade:9                Email:velit.aliquam@outlook.couk");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.print("Enrolled courses.");
            if (courses.length > 0) {
                for (int course : courses) {
                    System.out.println(course + "- 1,      Algorithms,    \"Scott, Austin C.\",    8 weeks,     2H,      Hall1");
                }
            } else {
                System.out.println("This student hasn't enrolled in any courses");
            }
        } else {
            System.out.println("Invalid Student ID");
        }
    }

}
