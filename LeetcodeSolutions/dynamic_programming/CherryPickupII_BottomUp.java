package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 26: Cherry Pickup II (LeetCode 1463)
 * 
 * Problem Statement:
 * Maximize cherries collected by two robots starting at (0, 0) and (0, cols-1).
 * 
 * Sample Input:
 * 3 3
 * 3 1 1
 * 2 5 1
 * 1 5 5
 * Sample Output:
 * Max Cherries: 24
 * 
 * Sample Input:
 * 2 2
 * 1 1
 * 1 1
 * Sample Output:
 * Max Cherries: 4
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[r][c1][c2] is the max cherries from row r down to the bottom.
 * 
 * Time Complexity: O(r * c^2)
 * Space Complexity: O(c^2) - space optimized.
 */
public class CherryPickupII_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("Enter grid values:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[c][c];

        // Base case: Last row
        for (int c1 = 0; c1 < c; c1++) {
            for (int c2 = 0; c2 < c; c2++) {
                dp[c1][c2] = grid[r - 1][c1];
                if (c1 != c2)
                    dp[c1][c2] += grid[r - 1][c2];
            }
        }

        // Move upwards
        for (int row = r - 2; row >= 0; row--) {
            int[][] nextDp = new int[c][c];
            for (int c1 = 0; c1 < c; c1++) {
                for (int c2 = 0; c2 < c; c2++) {
                    int cherries = grid[row][c1];
                    if (c1 != c2)
                        cherries += grid[row][c2];

                    int maxNext = 0;
                    for (int n1 = c1 - 1; n1 <= c1 + 1; n1++) {
                        for (int n2 = c2 - 1; n2 <= c2 + 1; n2++) {
                            if (n1 >= 0 && n1 < c && n2 >= 0 && n2 < c) {
                                maxNext = Math.max(maxNext, dp[n1][n2]);
                            }
                        }
                    }
                    nextDp[c1][c2] = cherries + maxNext;
                }
            }
            dp = nextDp;
        }

        System.out.println("Max Cherries: " + dp[0][c - 1]);
        sc.close();
    }
}
