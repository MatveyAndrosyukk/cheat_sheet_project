package project_structure.java_io_package.write_in_file.using_file_writer;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Hello Gold!";

        try(FileWriter writer = new FileWriter("file.txt", false))
        {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            throw new RuntimeException();
        }
    }
}
