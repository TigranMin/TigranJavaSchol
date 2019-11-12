package lesson4;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        CountMap<String> map = new CountMapIml<>();
        for (int i = 0; i < 5 ; i++) {
            map.add("a");
        }
        for (int i = 0; i < 4 ; i++) {
            map.add("b");
        }
        for (int i = 0; i < 5 ; i++) {
            map.add("c");
        }

        CountMap<String> map2 = new CountMapIml<>();
        for (int i = 0; i < 5 ; i++) {
            map2.add("a");
        }
        for (int i = 0; i < 6 ; i++) {
            map2.add("b");
        }
        for (int i = 0; i < 5 ; i++) {
            map2.add("e");
        }

        map.addAll(map2);
        System.out.println(map.remove("a"));

        System.out.println(map.getCount("a"));
        System.out.println(map.getCount("b"));
        System.out.println(map.getCount("c"));
        System.out.println(map.getCount("e"));

        Map<String, Integer> map3 = new HashMap<>();
        map.toMap(map3);
        System.out.println(map3);

    }



}
