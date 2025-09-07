package Strings;

public class CheckPallin {
    public static void main(String[] args) {
        String s = "MADAM";

        System.out.println(pallindrome(s, 0, s.length() - 1));
    }

    public static boolean pallindrome(String s, int l, int r) {
        if (l <= r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;

        return pallindrome(s, l++, r--);
    }
}
