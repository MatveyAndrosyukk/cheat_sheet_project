package project_structure.java_nio_package.write_in_file.standart_write_in_file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        try(FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("file.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(26);

            for (int i = 0; i < buffer.capacity(); i++) {
                buffer.put((byte) ('A' + i));
            }

            buffer.rewind();
            channel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
