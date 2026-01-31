package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 6: Minimum Path Sum (LeetCode 64)
 * 
 * Problem Statement:
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Sample Input:
 * 2 3
 * 1 3 1
 * 1 5 1
 * Sample Output:
 * Min Path Sum: 7 (1 -> 3 -> 1 -> 1 -> 1)
 * 
 * Sample Input:
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Sample Output:
 * Min Path Sum: 21
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(r, c) is the min sum to reach (r, c).
 * Transition: solve(r, c) = grid[r][c] + min(solve(r-1, c), solve(r, c-1))
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) for memo.
 */
public class MinPathSum_TopDown {
    private static int[][] memo;

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

        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Min Path Sum: " + solve(grid, m - 1, n - 1));
        sc.close();
    }

    private static int solve(int[][] grid, int r, int c) {
        if (r == 0 && c == 0)
            return grid[0][0];
        if (r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if (memo[r][c] != -1)
            return memo[r][c];

        int up = solve(grid, r - 1, c);
        int left = solve(grid, r, c - 1);

        memo[r][c] = grid[r][c] + Math.min(up, left);
        return memo[r][c];
    }
}
