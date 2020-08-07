package javay;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory2 {

    public static void sortFiles(String downloadsFilePath) throws IOException {
        for (Path path : Files.walk(Paths.get(downloadsFilePath), FileVisitOption.FOLLOW_LINKS)
                .filter(path -> path.toFile().isFile()).collect(Collectors.toSet())) {
            String newPath = downloadsFilePath + "\\new\\"
                    + path.toString().substring(path.toString().lastIndexOf(".") + 1) + "\\";
            Files.createDirectories(Path.of(newPath));
            Files.copy(path, Path.of(newPath + "\\" + path.getFileName()));
        }
    }
    public static void main(String[] args) throws IOException {
        sortFiles("C:\\Users\\Hrach\\Desktop\\Program\\");
    }
}
