import java.util.*;

/**
 * Problem 14: Palindrome Partitioning
 * 
 * Input Format:
 * A single string.
 * 
 * Output Format:
 * All possible ways to partition the string such that every substring is a
 * palindrome.
 * 
 * Approach:
 * Backtracking while verifying palindrome property for each substring
 * candidate.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);

        System.out.println("Partitions: " + result);
        sc.close();
    }

    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // Check if s[start...end] is palindrome
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}
