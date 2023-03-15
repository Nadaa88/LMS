import Admin.Courses;
import Admin.Student;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Reading students data...");
        StudentReader studentsReader = new StudentReader();
        ArrayList<Student> students = studentsReader.readData();

        //System.out.println("Reading courses data...");
        CourseseReader CoursesReader = new CourseseReader();
        ArrayList<Courses> courses = CoursesReader.readData();

        System.out.println("Welcome to LMS \n"
                + "created by Nada Othman \n \n"
        );


        while (true) {
            System.out.println(
                    "==================================================================================== \n"
                            + "Home Page \n \n"
                            + "==================================================================================== \n"
            );

            studentsReader.formatAndPrint(students);

            System.out.println("------------------------------------------------------------------------------------");
            // Scan user input ( student id )
            Scanner userInput = new Scanner(System.in);
            System.out.print("Please select the required student: ");

            String studentId = userInput.nextLine();

            try {
                int x = Integer.parseInt(studentId);
            }catch(NumberFormatException e) {
                System.out.println("\n The input you have provided is invalid, please enter a valid input \n");
                continue;
            }

            Student selectedStudent = null;
            for (Student student: students) {
                if (student.getId() == Integer.parseInt(studentId)) {
                    selectedStudent = student;
                    break;
                }
            }
            if (Objects.isNull(selectedStudent)) {
                System.out.print("The input you have provided is invalid, Student doesn't exist... \n");
                continue;
            }

            while (true) {

                System.out.println("==================================================================================== \n");
                System.out.println("Student Details page \n");
                System.out.println("==================================================================================== \n");
                System.out.println("Name: " + selectedStudent.getName() + "         " +  "Grade: "+ selectedStudent.getGrade() + "          " + "Email: "+ selectedStudent.getEmail());
                System.out.println("==================================================================================== \n");
                System.out.println("Enrolled Courses \n");
                if (selectedStudent.getCoursesEnrolled().size() != 0) {
                    // print courses list
                    ArrayList<Courses> studentCourses = new ArrayList<Courses>();
                    for (Integer studentCourse: selectedStudent.getCoursesEnrolled()) {
                        studentCourses.add(courses.get(studentCourse - 1));
                    }
                    CoursesReader.formatAndPrint(studentCourses);
                } else {
                    System.out.println("The student hasn't enrolled in any course yet. \n");
                }

                System.out.println("------------------------------------------------------------------------------------ \n");

                System.out.println("Please choose from the following: \n"
                        + "a - Enroll in a course \n"
                        + "d - Unenroll from an existing course \n"
                        + "r - Replacing an existing course \n"
                        + "b - Back to the main page \n"
                );
                System.out.print("please select the required action: ");
                char action = userInput.next().charAt(0);

                System.out.println("------------------------------------------------------------------------------------ \n");

                if (action == 'a') {
                    System.out.println("Enrollment page \n");
                    System.out.println("==================================================================================== \n");
                    CoursesReader.formatAndPrint(courses);

                    while (true) {
                        System.out.println("Please make one of the following: \n"
                                + "Enter the course id that you want to enroll the student to \n"
                                + "Enter b to go back to the home page \n");

                        System.out.print("please select the required action: ");
                        Scanner actionInput = new Scanner(System.in);
                        String action2 = actionInput.nextLine();

                        if ( action2.charAt(0) == 'b' ) {
                            break;
                        }


                        Courses courseData = null;
                        for (Courses course: courses) {
                            if (course.getId() == Integer.parseInt(action2)) {
                                courseData = course;
                                break;
                            }
                        }
                        if (!Objects.isNull(courseData)) {
                            try {
                                selectedStudent.enrollInCourse(courseData.getId());
                                System.out.println("The student is Enrolled Successfully in the " + courseData.getName() + " course \n");
                            } catch (Exception e) {
                                System.out.println("Failed to enroll:" + e.getMessage() + "\n");
                            }
                        } else {
                            System.out.println("Failed to enroll: The course with id = " + action2 + " does not exist\n");
                        }
                    }

                } else if ( action == 'd') {
                    if (selectedStudent.getCoursesEnrolled().size() <= 1) {
                        System.out.println("Faild to unenroll: The student as only one or no courses to unenroll from \n");
                        continue;
                    }
                    System.out.print("Please enter course id: ");
                    Scanner actionInput = new Scanner(System.in);
                    String action2 = actionInput.nextLine();

                    Courses courseData = null;
                    for (Courses course: courses) {
                        if (course.getId() == Integer.parseInt(action2)) {
                            courseData = course;
                            break;
                        }
                    }
                    if (!Objects.isNull(courseData)) {
                        try {
                            selectedStudent.unEnrollFromCourse(courseData.getId());
                            System.out.println("Unenrolled successfully from the " + courseData.getName()+ " course. \n");
                        } catch (Exception e) {
                            System.out.println("Failed to Unenroll:" + e.getMessage() + "\n");
                        }
                    } else {
                        System.out.println("Failed to Unenroll: The course with id = " + action2 + " does not exist\n");
                    }
                } else if ( action == 'r') {
                    if (selectedStudent.getCoursesEnrolled().size() == 0) {
                        System.out.println("Faild to replace as the student hasn't enrolled in any course yet. \n");
                        continue;
                    }
                    System.out.print("Please enter the course id to be replaced: ");
                    Scanner actionInput1 = new Scanner(System.in);
                    String action3 = actionInput1.nextLine();

                    Courses courseData1 = null;
                    for (Courses course: courses) {
                        if (course.getId() == Integer.parseInt(action3)) {
                            courseData1 = course;
                            break;
                        }
                    }
                    if (!Objects.isNull(courseData1)) {
                        System.out.print("Please enter the course id to replace: ");
                        Scanner actionInput2 = new Scanner(System.in);
                        String action4 = actionInput2.nextLine();

                        Courses courseData2 = null;
                        for (Courses course: courses) {
                            if (course.getId() == Integer.parseInt(action4)) {
                                courseData2 = course;
                                break;
                            }
                        }
                        if (!Objects.isNull(courseData2)) {
                            try {
                                selectedStudent.unEnrollFromCourse(courseData1.getId());
                                selectedStudent.enrollInCourse(courseData2.getId());
                                System.out.println("Courses replaced successfully from the " + courseData1.getName()+ " to " + courseData2.getName() + " course \n");
                            } catch (Exception e) {
                                System.out.println("Failed to Unenroll:" + e.getMessage() + "\n");
                            }
                        } else {
                            System.out.println("Failed to replace: The course with id = " + action4 + " does not exist\n");
                        }

                    } else {
                        System.out.println("Failed to replace: The course with id = " + action3 + " does not exist\n");
                    }
                } else if ( action == 'b') {
                    break;
                }
            }
        }
    }
}