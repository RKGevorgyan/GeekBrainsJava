package lesson3;

import java.util.*;

public class WordsCount {
    public static void main(String[] args) {
        String[] array = {"apple","orange","banana","apple","apricot","fig","grapes","kiwi",
                "avocado","date","lime","orange","banana","apple","fig","kiwi","mango","melon"};
        // Выводим уникальный список
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Unique: "+set);

        // Количество повторений
        Map<String,Integer> map = new HashMap<>();
        for (String s : array){
               // BiFunction
            //map.compute(s,(key,value)->value==null ? 1 : value+1);

              // condition
            map.put(s, map.containsKey(s) ? map.get(s)+1 : 1);
        }
        System.out.println("Count: "+map);
    }
}