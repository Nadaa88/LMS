package Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class File_reader extends InputStreamReader {

        public File_reader(String fileName) throws FileNotFoundException {
            super(new FileInputStream(fileName));
        }
    }