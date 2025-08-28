package Strings;

import java.util.*;

public class engthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your input String");
        String s = sc.next();

        int ans = maxLength(s);
        System.out.println(ans);
    }

    public static int maxLength(String s) {
        int r = 0, l = 0, maxL = 0;
        List<Character> list = new ArrayList<Character>();
        while (r < s.length()) {
            if (!list.contains(s.charAt(r))) {
                list.add(s.charAt(r));
                r++;
                maxL = Math.max(maxL, list.size());
            } else {
                list.remove(Character.valueOf(s.charAt(l)));
                l++;
            }
        }
        return maxL;
    }
}
