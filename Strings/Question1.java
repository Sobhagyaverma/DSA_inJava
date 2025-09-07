package Strings;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 50);
        map.put("Banana", 20);
        map.put("Mango", 30);

        // Values only
        System.out.println("Values:");
        for (int val : map.values()) {
            System.out.println(val);
        }

        // Keys + values
        System.out.println("\nKey-Value pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
