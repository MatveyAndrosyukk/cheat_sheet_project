package project_structure.java_io_package.read_from_file.using_input_stream;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void readToByteArray(){
        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer, 0, fileInputStream.available());
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
    public static void readFromFileBySymbol(){
        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        readFromFileBySymbol();
        readToByteArray();
    }
}
