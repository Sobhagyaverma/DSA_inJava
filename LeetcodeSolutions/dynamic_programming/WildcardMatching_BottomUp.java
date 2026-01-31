package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 21: Wildcard Matching (LeetCode 44)
 * 
 * Problem Statement:
 * Given an input string s and a pattern p, implement wildcard pattern matching.
 * 
 * Sample Input:
 * adceb *a*b
 * Sample Output:
 * Match: true
 * 
 * Sample Input:
 * acdb abc*
 * Sample Output:
 * Match: false
 * 
 * Approach: Bottom-Up (Tabulation)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class WildcardMatching_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.next();
        System.out.print("Enter pattern p: ");
        String p = sc.next();

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Base case: pattern matches empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        System.out.println("Match: " + dp[m][n]);
        sc.close();
    }
}
