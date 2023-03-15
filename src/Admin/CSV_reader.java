package Admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV_reader extends ArrayList<Courses> {

    String filePath;
    public CSV_reader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readAll() {
        try {
            Scanner scan = new Scanner(new File(this.filePath));
            ArrayList<String> records = new ArrayList<String>();
            while(scan.hasNext())
            {
                String record = scan.nextLine();
                records.add(record);
            }
            return records;
        } catch( IOException e) {
            e.printStackTrace();
            // handle exception correctly.
        }
        return null;
    }

    public void add(ArrayList<String> courses) {
    }

}


