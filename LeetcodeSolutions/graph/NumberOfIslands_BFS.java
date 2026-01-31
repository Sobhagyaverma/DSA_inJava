package graph;

import java.util.*;

/*
Problem Statement:
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), 
return the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically.

Input Format:
- m, n (dimensions)
- m lines of n chars ('0' or '1')

Output Format:
- Integer representing count.

Constraints:
- 1 <= m, n <= 300
*/

public class NumberOfIslands_BFS {
    /**
     * Traversal Logic:
     * - We iterate through the grid. When we find a '1', we increment the count
     * and start a BFS from that cell.
     * - BFS uses a Queue to visit all connected '1's and mark them as '0'.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N) - Every cell is visited once.
     * - Space Complexity: O(min(M, N)) - The size of the queue in the worst case
     * (diagonal).
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; // Mark as visited
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] d : dirs) {
                            int nr = curr[0] + d[0];
                            int nc = curr[1] + d[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; // Mark visited before adding to queue
                                queue.offer(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];
        System.out.println("Enter grid contents:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        NumberOfIslands_BFS solver = new NumberOfIslands_BFS();
        System.out.println("Result: " + solver.numIslands(grid));
        sc.close();
    }
}
