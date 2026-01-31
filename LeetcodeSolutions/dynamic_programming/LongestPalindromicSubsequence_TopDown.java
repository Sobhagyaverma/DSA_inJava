package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 11: Longest Palindromic Subsequence (LeetCode 516)
 * 
 * Problem Statement:
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * Sample Input:
 * bbbab
 * Sample Output:
 * LPS: 4 (bbbb)
 * 
 * Sample Input:
 * cbbd
 * Sample Output:
 * LPS: 2 (bb)
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * Logic: LPS(s) = LCS(s, reverse(s)).
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class LongestPalindromicSubsequence_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.next();

        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();

        memo = new int[n][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("LPS: " + solve(s, rev, n - 1, n - 1));
        sc.close();
    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + solve(s1, s2, i - 1, j - 1);
        } else {
            memo[i][j] = Math.max(solve(s1, s2, i - 1, j), solve(s1, s2, i, j - 1));
        }

        return memo[i][j];
    }
}
