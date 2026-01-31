package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 18: Interleaving String (LeetCode 97)
 * 
 * Problem Statement:
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
 * s1 and s2.
 * 
 * Sample Input:
 * xy x z xyz
 * Sample Output:
 * Interleaving: true
 * 
 * Sample Input:
 * a b ac
 * Sample Output:
 * Interleaving: false
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is boolean for s1[0...i-1] and s2[0...j-1] forming
 * s3[0...i+j-1].
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class InterleavingString_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s1: ");
        String s1 = sc.next();
        System.out.print("Enter s2: ");
        String s2 = sc.next();
        System.out.print("Enter s3: ");
        String s3 = sc.next();

        if (s1.length() + s2.length() != s3.length()) {
            System.out.println("Interleave: false");
        } else {
            int m = s1.length(), n = s2.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            // Fill first row (only s2)
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
            }

            // Fill first column (only s1)
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }

            System.out.println("Interleave: " + dp[m][n]);
        }
        sc.close();
    }
}
