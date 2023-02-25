package project_structure.java_nio_package.read_from_file.standart_read_from_file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int length;

        try(SeekableByteChannel channel = Files.newByteChannel(Paths.get("file.txt"))) {
            ByteBuffer buffer = ByteBuffer.allocate(128);

            do {
                length = channel.read(buffer);

                if (length != -1){
                    buffer.rewind();

                    for (int i = 0; i < length; i++) {
                        System.out.print((char) buffer.get());
                    }
                }
            }while (length != -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
