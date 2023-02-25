package project_structure.java_io_package.read_and_write.using_file_input_and_output_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("C://SomeDir//notes.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("C://SomeDir//notes_new.txt")) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
