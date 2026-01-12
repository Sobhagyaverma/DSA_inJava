package Strings;

import java.util.Collections;
import java.util.PriorityQueue;

public class Min_value {
    public static void main(String[] args) {
        String s = "aabbccd";
        System.out.println(minVal(s, 2));
    }

    public static int minVal(String s, int k) {
        int ans = 0;
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
            while (k > 0 && !maxHeap.isEmpty()) {
                int top = maxHeap.poll();
                top--;
                k--;
                if (top > 0) {
                    maxHeap.add(top);
                }

            }
        }
        while (!maxHeap.isEmpty()) {
            int m = maxHeap.poll();

            ans += m * m;
        }
        return ans;
    }
}
