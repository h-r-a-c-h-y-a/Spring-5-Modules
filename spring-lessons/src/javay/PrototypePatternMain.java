package javay;

import javay.main.model.generating_pattern.prototype.Account;
import javay.main.model.generating_pattern.prototype.AccountCache;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrototypePatternMain {
    public static void main(String[] args) throws IOException {
        Account currentAccount = (Account) AccountCache.accountCacheMap.get("CURRENT").clone();
        currentAccount.accountType();
        Account savingAccount = (Account) AccountCache.accountCacheMap.get("SAVING").clone();
        savingAccount.accountType();

//        sortFiles("C:\\Users\\Hrach\\Desktop\\Program\\");
    }
    public static void sortFiles(String filesPath) throws IOException {
        for (Path path : Files.walk(Paths.get( filesPath), FileVisitOption.FOLLOW_LINKS)
                .filter(path -> path.toFile().isFile()).collect(Collectors.toSet())) {
            String newPath = filesPath + "\\downloads\\"
                    + path.toString().substring(path.toString().lastIndexOf(".") + 1) + "\\";
            Files.createDirectories(Path.of(newPath));
            Files.copy(path, Path.of(newPath + "\\" + path.getFileName()));
        }
    }
}
