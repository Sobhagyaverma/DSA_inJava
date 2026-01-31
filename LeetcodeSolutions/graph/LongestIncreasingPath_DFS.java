package graph;

import java.util.Scanner;

/*
Problem Statement:
Given an m x n integers matrix, return the length of the longest increasing 
path in matrix. From each cell, you can either move in four directions: 
left, right, up, or down. You may not move diagonally or move outside the 
boundary.

Input Format:
- m, n
- m*n grid of integers

Output Format:
- Integer length.

Constraints:
- 1 <= m, n <= 200
- 0 <= matrix[i][j] <= 2^31 - 1
*/

public class LongestIncreasingPath_DFS {
    /**
     * Approach: DFS with Memoization
     * - For each cell, the longest increasing path starting from it is
     * 1 + max(longest increasing path of neighbors with strictly greater value).
     * - Use a memoization matrix 'cache[m][n]' to store results and avoid redundant
     * calculations.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N) - Each cell is computed once.
     * - Space Complexity: O(M * N) - For the cache.
     */
    private int[][] cache;
    private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        cache = new int[m][n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (cache[r][c] != 0)
            return cache[r][c];

        int max = 1;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length &&
                    matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, nr, nc));
            }
        }
        cache[r][c] = max;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }

        LongestIncreasingPath_DFS solver = new LongestIncreasingPath_DFS();
        System.out.println("Result: " + solver.longestIncreasingPath(matrix));
        sc.close();
    }
}
