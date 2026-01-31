package graph;

import java.util.*;

/*
Problem Statement:
There is an m x n rectangular island that borders both the Pacific Ocean 
and Atlantic Ocean. The Pacific Ocean touches the island's left and top 
edges, and the Atlantic Ocean touches the island's right and bottom edges.
The island is partitioned into a grid of square cells of heights heights.
Rainwater can flow to neighboring cells directly north, south, east, and west 
if the neighboring cell's height is less than or equal to the current cell's height. 
Water can flow from any cell adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates where rain water can flow to both oceans.

Input Format:
- m, n
- m*n grid of heights

Output Format:
- List of lists of [r, c]

Constraints:
- m, n <= 200
*/

public class PacificAtlantic_DFS {
    /**
     * Approach: Double DFS (Flowing from Ocean to Inland)
     * - We trace back from the oceans. For each ocean, perform DFS from its
     * bordering cells into cells with height >= current cell.
     * - Maintain two boolean matrices (reachable from Pacific, reachable from
     * Atlantic).
     * - Result is the intersection of these two sets.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N)
     * - Space Complexity: O(M * N)
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0)
            return result;
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Start DFS from edges
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, -1); // Left edge (Pacific)
            dfs(heights, atlantic, i, n - 1, -1); // Right edge (Atlantic)
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, -1); // Top edge (Pacific)
            dfs(heights, atlantic, m - 1, j, -1); // Bottom edge (Atlantic)
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int prevHeight) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length ||
                ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        ocean[r][c] = true;
        dfs(heights, ocean, r + 1, c, heights[r][c]);
        dfs(heights, ocean, r - 1, c, heights[r][c]);
        dfs(heights, ocean, r, c + 1, heights[r][c]);
        dfs(heights, ocean, r, c - 1, heights[r][c]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] heights = new int[m][n];
        System.out.println("Enter heights:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                heights[i][j] = sc.nextInt();
        }

        PacificAtlantic_DFS solver = new PacificAtlantic_DFS();
        System.out.println("Common flow coordinates: " + solver.pacificAtlantic(heights));
        sc.close();
    }
}
