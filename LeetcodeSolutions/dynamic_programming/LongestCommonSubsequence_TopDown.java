package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 10: Longest Common Subsequence (LeetCode 1143)
 * 
 * Problem Statement:
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * If there is no common subsequence, return 0.
 * 
 * Sample Input:
 * abcde ace
 * Sample Output:
 * LCS: 3 (ace)
 * 
 * Sample Input:
 * abc def
 * Sample Output:
 * LCS: 0
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class LongestCommonSubsequence_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String text1 = sc.next();
        System.out.print("Enter second string: ");
        String text2 = sc.next();

        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("LCS: " + solve(text1, text2, m - 1, n - 1));
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
