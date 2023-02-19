package project_structure.java_io_package.write_in_file.using_buffered_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Hello  World!\nHey! Teachers! Leave the kids alone.";

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt")))
        {
            bufferedWriter.write(text);
        }
        catch(IOException ex){
            throw new RuntimeException();
        }
    }
}
