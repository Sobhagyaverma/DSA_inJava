package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 12: Distinct Subsequences (LeetCode 115)
 * 
 * Problem Statement:
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * Sample Input:
 * apple ape
 * Sample Output:
 * Ways: 1
 * 
 * Sample Input:
 * banana ban
 * Sample Output:
 * Ways: 1
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] = ways to form t[0...j-1] from s[0...i-1].
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - can be optimized to O(n).
 */
public class DistinctSubsequences_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.next();
        System.out.print("Enter string t: ");
        String t = sc.next();

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Empty string t is a subsequence of any prefix of s
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Distinct Subsequences: " + dp[m][n]);
        sc.close();
    }
}
