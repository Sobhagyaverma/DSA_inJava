package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 13: Triangle (LeetCode 120)
 * 
 * Problem Statement:
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * 
 * Sample Input:
 * 4
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * Sample Output:
 * Min Path Sum: 11 (2+3+5+1)
 * 
 * Sample Input:
 * 1
 * -10
 * Sample Output:
 * Min Path Sum: -10
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(r, c) is min path sum from cell (r, c) to the bottom.
 * 
 * Time Complexity: O(n^2) where n is number of rows.
 * Space Complexity: O(n^2)
 */
public class Triangle_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<>();
        System.out.println("Enter triangle elements row by row:");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }
            triangle.add(row);
        }

        memo = new int[n][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Min Path Sum: " + solve(triangle, 0, 0, n));
        sc.close();
    }

    private static int solve(List<List<Integer>> triangle, int r, int c, int n) {
        if (r == n - 1)
            return triangle.get(r).get(c);
        if (memo[r][c] != -1)
            return memo[r][c];

        int down = solve(triangle, r + 1, c, n);
        int diag = solve(triangle, r + 1, c + 1, n);

        memo[r][c] = triangle.get(r).get(c) + Math.min(down, diag);
        return memo[r][c];
    }
}
