package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 22: Out of Boundary Paths (LeetCode 576)
 * 
 * Problem Statement:
 * Find the number of paths to move a ball out of m x n grid boundaries within
 * maxMove steps.
 * 
 * Sample Input:
 * 2 2 2 0 0
 * Sample Output:
 * Paths: 6
 * 
 * Sample Input:
 * 8 50 23 5 26
 * Sample Output:
 * Paths: 914783380 (Modulo result)
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[move][i][j] is number of paths to reach (i, j) in exactly 'move'
 * steps.
 * 
 * Time Complexity: O(m * n * maxMove)
 * Space Complexity: O(m * n) - space optimized to 2D.
 */
public class OutOfBoundaryPaths_BottomUp {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m and n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print("Enter maxMove: ");
        int maxMove = sc.nextInt();
        System.out.print("Enter startRow and startCol: ");
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();

        if (maxMove <= 0) {
            System.out.println("Paths: 0");
            sc.close();
            return;
        }

        int[][] dp = new int[m][n];
        dp[startRow][startCol] = 1;
        int count = 0;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int move = 1; move <= maxMove; move++) {
            int[][] nextDp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                count = (count + dp[r][c]) % MOD;
                            } else {
                                nextDp[nr][nc] = (nextDp[nr][nc] + dp[r][c]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        System.out.println("Paths: " + count);
        sc.close();
    }
}
