package project_structure.java_io_package.write_in_byte_array;

import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String text = "Hello World!";
        byte[] buffer = text.getBytes();
        try {
            byteArrayOutputStream.write(buffer);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

        // превращаем массив байтов в строку
        System.out.println(byteArrayOutputStream);

        // получаем массив байтов и выводим по символьно
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (byte eachByte : bytes) {
            System.out.print((char) eachByte);
        }
    }
}
