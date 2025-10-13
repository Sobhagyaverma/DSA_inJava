package Arrays;

import java.util.*;

public class Array1 {
    public static void main(String[] args) {
        String word = "hat";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();
            arr[i] = '1';
            list.add(new String(arr));
        }

        System.out.println(list);
    }
}