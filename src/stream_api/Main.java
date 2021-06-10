package stream_api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","3","2","7","8");
        System.out.println(list.stream().anyMatch( (x) -> x.contains("1")));
        list.stream().forEachOrdered( (x) -> x.toLowerCase());
        List list2 = list.stream().map( (x) -> x + "__*").collect(Collectors.toList());
        list2.stream().forEachOrdered( (x) -> System.out.println(x));
    }
}
