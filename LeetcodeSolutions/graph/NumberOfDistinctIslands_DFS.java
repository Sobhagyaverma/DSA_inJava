package graph;

import java.util.*;

/*
Problem Statement:
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
connected 4-directionally. We consider two islands to be the same if and only 
if one island can be translated (and not rotated or reflected) to equal the other.
Return the number of distinct islands.

Input Format:
- m, n
- m*n grid of 0s and 1s

Output Format:
- Integer representing count of distinct shapes.

Constraints:
- 1 <= m, n <= 50
*/

public class NumberOfDistinctIslands_DFS {
    /**
     * Approach: DFS with Path Encoding
     * - To detect distinct shapes, we need a way to represent each island's
     * geometry.
     * - During DFS, we record the relative directions moved ('u', 'd', 'l', 'r')
     * and a backtrack marker ('b').
     * - The string formed for each island is unique to its shape.
     * - Store these strings in a Set to count unique islands.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N)
     * - Space Complexity: O(M * N)
     */
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> distinctShapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 'o'); // 'o' for origin
                    distinctShapes.add(sb.toString());
                }
            }
        }
        return distinctShapes.size();
    }

    private void dfs(int[][] grid, int r, int c, StringBuilder sb, char dir) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0; // Mark visited
        sb.append(dir);

        dfs(grid, r + 1, c, sb, 'd');
        dfs(grid, r - 1, c, sb, 'u');
        dfs(grid, r, c + 1, sb, 'r');
        dfs(grid, r, c - 1, sb, 'l');

        sb.append('b'); // Backtrack marker is crucial to distinguish shapes
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter grid (0s and 1s):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        NumberOfDistinctIslands_DFS solver = new NumberOfDistinctIslands_DFS();
        System.out.println("Distinct Islands: " + solver.numDistinctIslands(grid));
        sc.close();
    }
}
