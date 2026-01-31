package dynamic_programming;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 13: Triangle (LeetCode 120)
 * 
 * Problem Statement:
 * Given a triangle array, find the minimum path sum from top to bottom.
 * 
 * Sample Input:
 * 2
 * 1
 * 2 3
 * Sample Output:
 * Min Path Sum: 3
 * 
 * Sample Input:
 * 3
 * 1
 * 4 5
 * 2 3 6
 * Sample Output:
 * Min Path Sum: 7 (1+4+2)
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[c] stores the minimum path sum from the current row to the bottom.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) - space optimized.
 */
public class Triangle_BottomUp {
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

        // Initialize dp with the last row
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Move upwards from second to last row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        System.out.println("Min Path Sum: " + dp[0]);
        sc.close();
    }
}
