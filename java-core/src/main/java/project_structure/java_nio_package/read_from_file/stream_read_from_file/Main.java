package project_structure.java_nio_package.read_from_file.stream_read_from_file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int content;

        try(InputStream inputStream = Files.newInputStream(Paths.get("file.txt"))) {
            do {
                content = inputStream.read();

                if (content != -1){
                    System.out.println((char) content);
                }
            }while (content != -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
