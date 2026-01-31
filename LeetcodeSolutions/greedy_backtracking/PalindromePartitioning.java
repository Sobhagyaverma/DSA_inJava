package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given a string s, partition s such that every substring of the partition 
is a palindrome. Return all possible palindrome partitioning of s.

Input Format:
- A string s

Output Format:
- List of lists of palindromic substrings

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

Sample Input:
"aab"
Sample Output:
[["a","a","b"],["aa","b"]]
*/

public class PalindromePartitioning {
    /**
     * Backtracking Approach:
     * We try all possible cuts starting from the beginning of the string.
     * If the left part of the cut is a palindrome, we recursively search
     * for partitions in the right part.
     * 
     * Choice: Cut the string into s[start...i] and s[i+1...end].
     * Recursive Call: Call for s[i+1...end] if s[start...i] is a palindrome.
     * Backtrack: Remove the palindromic substring from the current path.
     * 
     * Time Complexity: O(N * 2^N) - there are 2^N possible partitions.
     * Space Complexity: O(N) - Recursion depth.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        // Base case: we reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);

            // Pruning: only proceed if the current prefix is a palindrome
            if (isPalindrome(sub)) {
                // Choice
                current.add(sub);

                // Recursive Call
                backtrack(result, current, s, i + 1);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        if (!sc.hasNext())
            return;
        String s = sc.next();

        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> results = obj.partition(s);

        System.out.println("Partitions:");
        for (List<String> p : results)
            System.out.println(p);

        sc.close();
    }
}
