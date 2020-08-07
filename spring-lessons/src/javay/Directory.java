package javay;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
    String path = "C:\\Users\\Hrach\\Desktop\\Program";
    File file = new File(path);
    List<String> fileNameList = new ArrayList<>();

    public void addFileNamesToList() {
        if (!file.isDirectory()) {
            throw new RuntimeException("Unable find " + path + " directory");
        } else {
            File[] files = file.listFiles();
            for (File file: files) fileNameList.add(file.getName());
        }
    }

    public void createFolders() {
        for (String string: fileNameList){
            String newFolder = string.substring(string.lastIndexOf(".") + 1); //html,pdf,mp3...
            File file = new File(path + "\\new_folders\\" + newFolder);
            file.mkdirs();
        }
    }

    public void moveFiles() {
        for (String string: fileNameList) {
            String newFolder = string.substring(string.lastIndexOf(".") + 1); //html,pdf,mp3...
            File file = new File(path + "\\" + string);
            file.renameTo(new File(path + "\\" + newFolder + "\\" + string));
        }
    }

    public static void main(String[] args) {
        Directory directory = new Directory();
        directory.addFileNamesToList();
        directory.fileNameList.forEach(System.out::println);
        directory.createFolders();
        directory.moveFiles();
    }
}
