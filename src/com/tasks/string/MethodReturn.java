package com.tasks.string;
import java.util.ArrayList;
import java.util.List;


public class MethodReturn {

    public static List<String> getList() {

        String[] arr = {"abc", "def", "ghi", "lkl", "mno"};
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = getList();
        list.forEach( s -> {
            System.out.println(s);
        });
    }

}
