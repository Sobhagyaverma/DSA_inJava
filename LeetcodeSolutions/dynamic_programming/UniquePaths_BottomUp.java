package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 5: Unique Paths (LeetCode 62)
 * 
 * Problem Statement:
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (0, 0).
 * Return the number of unique paths to the bottom-right corner.
 * 
 * Sample Input:
 * 3 2
 * Sample Output:
 * Paths: 3
 * 
 * Sample Input:
 * 3 3
 * Sample Output:
 * Paths: 6
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is number of paths to cell (i, j).
 * Transition: dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - can be optimized to O(n).
 */
public class UniquePaths_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (m <= 0 || n <= 0) {
            System.out.println("Paths: 0");
        } else {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++)
                dp[i][0] = 1;
            for (int j = 0; j < n; j++)
                dp[0][j] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println("Paths: " + dp[m - 1][n - 1]);
        }
        sc.close();
    }
}
