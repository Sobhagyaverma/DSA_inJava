package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 14: Maximal Square (LeetCode 221)
 * 
 * Problem Statement:
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Sample Input:
 * 4 5
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Sample Output:
 * Max Area: 4
 * 
 * Sample Input:
 * 2 2
 * 0 1
 * 1 0
 * Sample Output:
 * Max Area: 1
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(r, c) is side of max square ending at (r, c).
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class MaximalSquare_TopDown {
    private static int[][] memo;
    private static int maxSide = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m and n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] matrix = new char[m][n];
        System.out.println("Enter matrix ('0' or '1'):");
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        // We need to call for every cell to find global maxSide
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j);
            }
        }

        System.out.println("Max Area: " + (maxSide * maxSide));
        sc.close();
    }

    private static int solve(char[][] matrix, int r, int c) {
        if (r < 0 || c < 0)
            return 0;
        if (memo[r][c] != -1)
            return memo[r][c];

        if (matrix[r][c] == '0') {
            memo[r][c] = 0;
        } else {
            int diag = solve(matrix, r - 1, c - 1);
            int up = solve(matrix, r - 1, c);
            int left = solve(matrix, r, c - 1);
            memo[r][c] = 1 + Math.min(diag, Math.min(up, left));
        }

        maxSide = Math.max(maxSide, memo[r][c]);
        return memo[r][c];
    }
}
