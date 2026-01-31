package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 24: Burst Balloons (LeetCode 312)
 * 
 * Problem Statement:
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Sample Input:
 * 4
 * 3 1 5 8
 * Sample Output:
 * Max Coins: 167
 * 
 * Sample Input:
 * 1
 * 5
 * Sample Output:
 * Max Coins: 5
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j] is max coins by bursting balloons in range [i, j].
 * 
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */
public class BurstBalloons_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;
        System.out.println("Enter balloon values:");
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 2][n + 2];

        // Length of interval from 1 to n
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        System.out.println("Max Coins: " + dp[1][n]);
        sc.close();
    }
}
