package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 20: Regular Expression Matching (LeetCode 10)
 * 
 * Problem Statement:
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * Sample Input:
 * mississippi mis*is*p*.
 * Sample Output:
 * Match: false
 * 
 * Sample Input:
 * aab c*a*b
 * Sample Output:
 * Match: true
 * 
 * Approach: Bottom-Up (Tabulation)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class RegularExpressionMatching_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.next();
        System.out.print("Enter pattern p: ");
        String p = sc.next();

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Base case: p matches empty s
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Scenario 1: '*' matches 0 characters
                    dp[i][j] = dp[i][j - 2];
                    // Scenario 2: '*' matches 1 or more characters
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println("Match: " + dp[m][n]);
        sc.close();
    }
}
