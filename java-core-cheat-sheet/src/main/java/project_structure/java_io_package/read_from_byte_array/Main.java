package project_structure.java_io_package.read_from_byte_array;

import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
        int data;
        while ((data = byteArrayInputStream.read()) != -1) {
            System.out.println(data);
        }
    }
}
