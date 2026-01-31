package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 5: Unique Paths (LeetCode 62)
 * 
 * Problem Statement:
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (0, 0).
 * The robot tries to move to the bottom-right corner (m - 1, n - 1). The robot
 * can only move either down or right at any point in time.
 * 
 * Sample Input:
 * 3 7
 * Sample Output:
 * Paths: 28
 * 
 * Sample Input:
 * 3 2
 * Sample Output:
 * Paths: 3
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(r, c) is number of paths to (r, c).
 * Transition: solve(r, c) = solve(r-1, c) + solve(r, c-1)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) for memo.
 */
public class UniquePaths_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (m <= 0 || n <= 0) {
            System.out.println("Paths: 0");
        } else {
            memo = new int[m][n];
            for (int[] row : memo)
                Arrays.fill(row, -1);
            System.out.println("Paths: " + solve(m - 1, n - 1));
        }
        sc.close();
    }

    private static int solve(int r, int c) {
        if (r == 0 || c == 0)
            return 1;
        if (memo[r][c] != -1)
            return memo[r][c];

        memo[r][c] = solve(r - 1, c) + solve(r, c - 1);
        return memo[r][c];
    }
}
