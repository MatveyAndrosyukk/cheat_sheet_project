package project_structure.java_io_package.read_and_write.using_buffered_reader_and_writer;

import java.io.*;

public class Main {
    public static void readFromConsoleAndWriteToFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"))) {
            String text;
            while (!(text = bufferedReader.readLine()).equals("ESC")) {
                bufferedWriter.write(text + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        readFromConsoleAndWriteToFile();
    }
}
