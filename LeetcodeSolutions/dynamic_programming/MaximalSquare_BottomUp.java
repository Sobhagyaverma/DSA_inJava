package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 14: Maximal Square (LeetCode 221)
 * 
 * Problem Statement:
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Sample Input:
 * 3 3
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * Sample Output:
 * Max Area: 9
 * 
 * Sample Input:
 * 2 2
 * 1 0
 * 0 1
 * Sample Output:
 * Max Area: 1
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is the side length of the maximal square whose bottom-right
 * corner is (i, j).
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - can be optimized to O(n).
 */
public class MaximalSquare_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m and n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m <= 0 || n <= 0) {
            System.out.println("Max Area: 0");
            sc.close();
            return;
        }

        char[][] matrix = new char[m][n];
        System.out.println("Enter matrix ('0' or '1'):");
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        System.out.println("Max Area: " + (maxSide * maxSide));
        sc.close();
    }
}
