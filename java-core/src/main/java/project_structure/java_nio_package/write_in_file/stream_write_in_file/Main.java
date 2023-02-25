package project_structure.java_nio_package.write_in_file.stream_write_in_file;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, world";
        byte[] bytes = text.getBytes();

        try(OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("file.txt")))) {
            for (byte eachByte: bytes) {
                outputStream.write(eachByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
