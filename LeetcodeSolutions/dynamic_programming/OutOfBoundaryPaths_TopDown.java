package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 22: Out of Boundary Paths (LeetCode 576)
 * 
 * Problem Statement:
 * There is an m x n grid with a ball. The ball is initially at the position
 * [startRow, startColumn].
 * You can move the ball to one of the four adjacent cells. You can apply at
 * most maxMove moves to the ball.
 * Return the number of paths to move the ball out of the grid boundary.
 * 
 * Sample Input:
 * 2 2 2 0 0
 * Sample Output:
 * Paths: 6
 * 
 * Sample Input:
 * 1 3 3 0 1
 * Sample Output:
 * Paths: 12
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(m * n * maxMove)
 * Space Complexity: O(m * n * maxMove)
 */
public class OutOfBoundaryPaths_TopDown {
    private static int[][][] memo;
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

        memo = new int[m][n][maxMove + 1];
        for (int[][] surface : memo) {
            for (int[] row : surface)
                Arrays.fill(row, -1);
        }

        System.out.println("Paths: " + solve(m, n, maxMove, startRow, startCol));
        sc.close();
    }

    private static int solve(int m, int n, int maxMove, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return 1;
        if (maxMove == 0)
            return 0;
        if (memo[r][c][maxMove] != -1)
            return memo[r][c][maxMove];

        long paths = 0;
        paths = (paths + solve(m, n, maxMove - 1, r + 1, c)) % MOD;
        paths = (paths + solve(m, n, maxMove - 1, r - 1, c)) % MOD;
        paths = (paths + solve(m, n, maxMove - 1, r, c + 1)) % MOD;
        paths = (paths + solve(m, n, maxMove - 1, r, c - 1)) % MOD;

        memo[r][c][maxMove] = (int) paths;
        return memo[r][c][maxMove];
    }
}
