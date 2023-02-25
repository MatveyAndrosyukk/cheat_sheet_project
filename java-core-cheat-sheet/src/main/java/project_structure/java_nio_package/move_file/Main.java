package project_structure.java_nio_package.move_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("file.txt"), destination = Paths.get("src/file.txt");
            Files.move(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
