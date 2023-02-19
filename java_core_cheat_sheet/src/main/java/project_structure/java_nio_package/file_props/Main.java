package project_structure.java_nio_package.file_props;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("file.txt");

        System.out.println("Имя файла:" + path.getFileName());
        System.out.println("Путь к файлу:" + path);
        System.out.println("Существует ли файл:" + Files.exists(path));
        System.out.println("Спрятан ли:" + Files.isHidden(path));
        System.out.println("Доступен ли файл для чтения:" + Files.isReadable(path));
        System.out.println("Доступен ли файл для записи:" + Files.isWritable(path));

        BasicFileAttributes fileAttributes =    Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Являетсял и переданный файл папкой:" + fileAttributes.isDirectory());
        System.out.println("Являетсял и переданный файл обчным файлом:" + fileAttributes.isRegularFile());
        System.out.println("Являетсял и переданный файл символической ссылкой:" + fileAttributes.isSymbolicLink());
        System.out.println("Дата последней модификации файла:" + fileAttributes.lastModifiedTime());
        System.out.println("Размер файла:" + fileAttributes.size());
    }
}
