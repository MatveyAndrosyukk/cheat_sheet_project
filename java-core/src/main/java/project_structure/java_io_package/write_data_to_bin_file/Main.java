package project_structure.java_io_package.write_data_to_bin_file;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 34, 1.68, false);
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(Paths.get("data.bin")))) {
            dataOutputStream.writeUTF(tom.name);
            dataOutputStream.writeInt(tom.age);
            dataOutputStream.writeDouble(tom.height);
            dataOutputStream.writeBoolean(tom.married);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
