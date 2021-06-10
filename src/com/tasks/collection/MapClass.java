package com.tasks.collection;

import java.util.HashMap;
import java.util.Map;

public class MapClass {
    public static void main(String[] args) {

        Map<String, Long> result = new HashMap<>();
        result.put("Низкий", 1L);
        result.put("Средний", 3L);
        result.put("Высокий", 3L);
        result.put("Высокий+", 0L);
        result.put("Total", 7L);

        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        map.put("widget", result);

        System.out.println();
        String s = "";
        int count = 0;
        for (Map.Entry pair : map.entrySet()) {
            if (map.size() - 1 == count) {
                s += pair.getKey() + ":" + pair.getValue();
            } else {
                s += pair.getKey() + ":" + pair.getValue() + ",";
            }
            count++;
        }
        System.out.println(s);
        //return {"result":"success","widget":{"Низкий":34,"Средний":3,"Total":43,"Высокий+":0,"Высокий":6}}
    }
}
