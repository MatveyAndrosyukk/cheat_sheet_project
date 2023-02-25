package project_structure.java_io_package.read_from_file.using_buffered_reader;

import java.io.*;

public class Main {
    public static void readBySymbols() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("notes4.txt"))) {
            int data;
            while ((data = bufferedReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public static void readByLines() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        readBySymbols();
        readByLines();
    }
}
