package project_structure.java_nio_package.write_in_file.mapped_write_in_file;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("file.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            for (int i = 0; i < buffer.capacity(); i++) {
                buffer.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
