package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 11: Longest Palindromic Subsequence (LeetCode 516)
 * 
 * Problem Statement:
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * Sample Input:
 * bbbab
 * Sample Output:
 * LPS: 4
 * 
 * Sample Input:
 * character
 * Sample Output:
 * LPS: 5 (carac)
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is the length of LPS in s[i...j].
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class LongestPalindromicSubsequence_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.next();
        int n = s.length();

        int[][] dp = new int[n][n];

        // Base case: every single character is a palindrome of length 1
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        // Fill table for lengths 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("LPS: " + dp[0][n - 1]);
        sc.close();
    }
}
