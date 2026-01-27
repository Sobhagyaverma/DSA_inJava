import java.util.*;

/**
 * Problem 24: Unique Paths III
 * 
 * Input Format:
 * m n, then grid (1=start, 2=end, 0=empty, -1=obstacle).
 * 
 * Output Format:
 * Number of paths that visit every empty cell exactly once.
 * 
 * Approach:
 * Backtracking (DFS) with a count of remaining empty cells.
 */
public class UniquePathsIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimensions (m n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        int startX = 0, startY = 0, emptyCount = 0;

        System.out.println("Enter grid values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        // +1 for the starting cell
        System.out.println("Unique Paths: " + backtrack(grid, startX, startY, emptyCount + 1));
        sc.close();
    }

    private static int backtrack(int[][] grid, int r, int c, int remaining) {
        // Base case: reached target
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1)
            return 0;

        if (grid[r][c] == 2) {
            return remaining == 0 ? 1 : 0;
        }

        // Action: mark visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        int paths = backtrack(grid, r + 1, c, remaining - 1) +
                backtrack(grid, r - 1, c, remaining - 1) +
                backtrack(grid, r, c + 1, remaining - 1) +
                backtrack(grid, r, c - 1, remaining - 1);

        // Backtrack
        grid[r][c] = temp;
        return paths;
    }
}
