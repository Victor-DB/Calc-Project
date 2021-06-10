package com.tasks.string;

import java.util.*;

/**
 * Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.
 * Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.
 * Затем вывести только группы, содержащие более одного элемента.
 * Группы должны быть отсортированы в алфавитном порядке.
 * Слова внутри группы нужно сортировать по убыванию количества символов; если количество символов равное, то сортировать в алфавитном порядке.
 * Пример строки: String s = «сапог сарай арбуз болт бокс биржа»
 * Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]
 */
public class SortStringTask {
    public static void main(String[] args) {
        String str = "сапог сарай сыр самосвал море арбуз болт ф бокс биржа млекопитающее земля рай герб бананы запах заземление аванс морос мороз затмение спор роса гроза метель";

        compareStrByLength(
                moreThanOneElement(
                        groupByFirstChar(
                                str)
                )
        ).entrySet().forEach( (m) -> {
            System.out.println(m.getKey() + " : " + m.getValue());
        });
    }

    private static Map<String, List<String>> groupByFirstChar(String str) {
        String[] words = str.split(" ");
        Map<String, List<String>> map  = new TreeMap<>();
        for(String word: words) {
            List<String> list = new ArrayList<>();
            String sym = word.substring(0, 1);
            if (!map.containsKey(sym)) {
                    list.add(word);
                    map.put(sym, list);
            } else {  if(!map.get(sym).contains(word)) {  map.get(sym).add(word);  } }
        }
        return map;
    }

    private static Map<String, List<String>> moreThanOneElement(Map<String, List<String>> map) {
        map.entrySet().forEach( (m) -> {
            if (m.getValue().size() <= 1) {  map.remove(m.getKey(), m.getValue());  }
        });
        return map;
    }

    private static Map<String, List<String>> compareStrByLength(Map<String, List<String>> map) {
        map.entrySet().forEach( (m) -> {
            List<String> list = m.getValue();

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j).length() > list.get(i).length()) {
                        String s = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, s);

                    } else if (list.get(j).length() == list.get(i).length()) {
                        boolean result = compareStrByAlphabet(list.get(j), list.get(i));
                        if (result) {
                            String s = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, s);
                        }
                    }
                }
            }

        });

        return map;
    }

    public static boolean compareStrByAlphabet(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        boolean result = false;
        int len = Math.min(aChar.length, bChar.length);
        for(int i = 0; i < len; i++) {
            if (aChar[i] == bChar[i]) {  continue; }
            else if (aChar[i] < bChar[i]) {  result = true; }
            else {  result = false;  }
        }
        return result;
    }
}