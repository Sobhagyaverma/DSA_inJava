package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 6: Minimum Path Sum (LeetCode 64)
 * 
 * Problem Statement:
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Sample Input:
 * 3 3
 * 1 3 1
 * 1 5 1
 * 4 2 1
 * Sample Output:
 * Min Path Sum: 7
 * 
 * Sample Input:
 * 2 2
 * 1 2
 * 1 1
 * Sample Output:
 * Min Path Sum: 3
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is the min path cost to reach cell (i, j).
 * Transition: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - can be optimized to O(n).
 */
public class MinPathSum_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m and n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter grid values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // Fill first row
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        // Fill first column
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println("Min Path Sum: " + dp[m - 1][n - 1]);
        sc.close();
    }
}
