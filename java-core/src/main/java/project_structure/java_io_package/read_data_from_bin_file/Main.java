package project_structure.java_io_package.read_data_from_bin_file;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (DataInputStream dos = new DataInputStream(Files.newInputStream(Paths.get("data.bin")))) {
            String name = dos.readUTF();
            int age = dos.readInt();
            double height = dos.readDouble();
            boolean married = dos.readBoolean();
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
