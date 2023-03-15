import Admin.CSV_reader;
import Admin.Student;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class StudentReader {
    public ArrayList<Student> readData() {
        CSV_reader studentReader = new CSV_reader("E:\\New folder\\testing\\front end testing\\LMS.Project\\LMS\\src\\student-data1-simplified.csv");
        ArrayList<String> students = new ArrayList<String>();

        students = (ArrayList<String>) studentReader.readAll();

        ArrayList<Student> studentsList = new ArrayList<Student>();

        for (int i = 1; i < students.size(); i++) {
            String studentData = students.get(i);
            Student student = new Student();
            String[] data = studentData.split(",");
            student.setId(parseInt(data[0]));
            student.setName(data[1]);
            student.setGrade(parseInt(data[2]));
            student.setEmail(data[3]);
            student.setAddress(data[4]);
            student.setRegion(data[5]);
            student.setCountry(data[6]);
            studentsList.add(student);
        }
        return studentsList;
    }

    public void formatAndPrint(ArrayList<Student> students) {
        //prints the list objects in tabular format
        System.out.printf("%5s %20s %17s %20s %25s %27s %10s", "id", "name", "grade", "email", "address", "region", "country");
        System.out.println();
        //iterates over the list
        for(Student student: students)
        {
            System.out.format("%5s %25s %10s %30s %-30s %15s %15s", student.getId(), student.getName(), student.getGrade(), student.getEmail(), student.getAddress(), student.getRegion(), student.getCountry());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
