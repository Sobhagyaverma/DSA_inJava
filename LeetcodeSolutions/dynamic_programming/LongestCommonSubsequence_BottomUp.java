package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 10: Longest Common Subsequence (LeetCode 1143)
 * 
 * Problem Statement:
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * Sample Input:
 * abc abc
 * Sample Output:
 * LCS: 3
 * 
 * Sample Input:
 * ace abcde
 * Sample Output:
 * LCS: 3
 * 
 * Approach: Bottom-Up (Tabulation)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - can be optimized to O(n).
 */
public class LongestCommonSubsequence_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String text1 = sc.next();
        System.out.print("Enter second string: ");
        String text2 = sc.next();

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("LCS: " + dp[m][n]);
        sc.close();
    }
}
