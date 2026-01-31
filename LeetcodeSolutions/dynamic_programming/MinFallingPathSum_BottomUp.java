package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 19: Minimum Falling Path Sum (LeetCode 931)
 * 
 * Problem Statement:
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * Sample Input:
 * 3
 * 2 1 3
 * 6 5 4
 * 7 8 9
 * Sample Output:
 * Min Falling Path Sum: 13
 * 
 * Sample Input:
 * 2
 * 10 20
 * 30 40
 * Sample Output:
 * Min Falling Path Sum: 40
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is the min falling sum to reach (i, j).
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2) - can be optimized to O(n).
 */
public class MinFallingPathSum_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int diagLeft = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int diagRight = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(diagLeft, diagRight));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        System.out.println("Min Falling Path Sum: " + minSum);
        sc.close();
    }
}
