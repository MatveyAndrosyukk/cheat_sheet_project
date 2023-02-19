package project_structure.java_io_package.read_from_file.using_file_reader;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("notes3.txt")) {
            int data;

            while((data = reader.read()) != -1){
                System.out.print((char)data);
            }
        }
        catch(IOException ex){
            throw new RuntimeException();
        }
    }
}
