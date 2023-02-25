package project_structure.java_io_package.write_in_file.using_file_output_stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world!";
        try (FileOutputStream fileOutputStream = new FileOutputStream("C://SomeDir//notes.txt")) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
