package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 19: Minimum Falling Path Sum (LeetCode 931)
 * 
 * Problem Statement:
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element
 * in the next row
 * that is either directly below it or diagonally left/right.
 * 
 * Sample Input:
 * 3
 * 2 1 3
 * 6 5 4
 * 7 8 9
 * Sample Output:
 * Min Falling Path Sum: 13 (2+5+7 or 1+5+7)
 * 
 * Sample Input:
 * 2
 * -19 57
 * -40 -5
 * Sample Output:
 * Min Falling Path Sum: -59
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class MinFallingPathSum_TopDown {
    private static int[][] memo;

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

        memo = new int[n][n];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, solve(matrix, 0, j, n));
        }

        System.out.println("Min Falling Path Sum: " + minSum);
        sc.close();
    }

    private static int solve(int[][] matrix, int r, int c, int n) {
        if (c < 0 || c >= n)
            return 1000000; // Large value for out of bounds
        if (r == n - 1)
            return matrix[r][c];
        if (memo[r][c] != Integer.MAX_VALUE)
            return memo[r][c];

        int d1 = solve(matrix, r + 1, c - 1, n);
        int d2 = solve(matrix, r + 1, c, n);
        int d3 = solve(matrix, r + 1, c + 1, n);

        memo[r][c] = matrix[r][c] + Math.min(d1, Math.min(d2, d3));
        return memo[r][c];
    }
}
