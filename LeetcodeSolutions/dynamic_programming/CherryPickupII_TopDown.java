package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 26: Cherry Pickup II (LeetCode 1463)
 * 
 * Problem Statement:
 * You are given a rows x cols matrix grid representing a field of cherries
 * where grid[i][j] represents the number of cherries
 * that you can collect from the (i, j) cell. Two robots can move through the
 * field to collect cherries.
 * Robot #1 starts at (0, 0), and Robot #2 starts at (0, cols-1). Return the
 * maximum number of cherries collected.
 * 
 * Sample Input:
 * 3 3
 * 3 1 1
 * 2 5 1
 * 1 5 5
 * Sample Output:
 * Max Cherries: 24
 * 
 * Sample Input:
 * 2 3
 * 1 1 1
 * 1 1 1
 * Sample Output:
 * Max Cherries: 4
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(row, col1, col2)
 * 
 * Time Complexity: O(r * c^2)
 * Space Complexity: O(r * c^2)
 */
public class CherryPickupII_TopDown {
    private static int[][][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("Enter grid values:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        memo = new int[r][c][c];
        for (int[][] surface : memo) {
            for (int[] row : surface)
                Arrays.fill(row, -1);
        }

        System.out.println("Max Cherries: " + solve(grid, 0, 0, c - 1));
        sc.close();
    }

    private static int solve(int[][] grid, int r, int c1, int c2) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols)
            return -1000000;
        if (r == rows)
            return 0;
        if (memo[r][c1][c2] != -1)
            return memo[r][c1][c2];

        int result = grid[r][c1];
        if (c1 != c2)
            result += grid[r][c2];

        int maxNext = 0;
        for (int nextC1 = c1 - 1; nextC1 <= c1 + 1; nextC1++) {
            for (int nextC2 = c2 - 1; nextC2 <= c2 + 1; nextC2++) {
                maxNext = Math.max(maxNext, solve(grid, r + 1, nextC1, nextC2));
            }
        }

        result += maxNext;
        memo[r][c1][c2] = result;
        return result;
    }
}
