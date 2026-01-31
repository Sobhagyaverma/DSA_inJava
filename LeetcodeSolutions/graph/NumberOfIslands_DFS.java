package graph;

import java.util.Scanner;

/*
Problem Statement:
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), 
return the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically.

Input Format:
- m, n (dimensions)
- m lines of n space-separated characters ('0' or '1')

Output Format:
- Integer representing the number of islands.

Constraints:
- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 300
- grid[i][j] is '0' or '1'.
*/

public class NumberOfIslands_DFS {
    /**
     * Traversal Logic:
     * - Iterate through every cell in the grid.
     * - When we encounter a '1', it's a new island. Increment the counter.
     * - Trigger DFS to visit and mark all connected land ('1') as visited (or '0'
     * to save space).
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N) - Every pixel is visited once.
     * - Space Complexity: O(M * N) - Worst case recursion stack for an all-land
     * grid.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary and water checks
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Mark as visited (water)
        grid[r][c] = '0';

        // Traverse 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];
        System.out.println("Enter grid (0s and 1s):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        NumberOfIslands_DFS solver = new NumberOfIslands_DFS();
        System.out.println("Number of islands: " + solver.numIslands(grid));
        sc.close();
    }
}
