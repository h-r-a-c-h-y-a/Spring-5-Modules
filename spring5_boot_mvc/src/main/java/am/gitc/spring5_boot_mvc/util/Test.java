package am.gitc.spring5_boot_mvc.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Test {

    static public void modify(List<Integer> list) {
        list.replaceAll(r -> r * r);
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1, 2, 3, 4);
        list.forEach(System.out::println);
        Test.modify(list);
        System.out.println();
        list.forEach(System.out::println);
    }
}
