package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 24: Burst Balloons (LeetCode 312)
 * 
 * Problem Statement:
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums.
 * You are asked to burst all the balloons. If you burst the ith balloon, you
 * will get nums[i - 1] * nums[i] * nums[i + 1] coins.
 * After the burst, the i - 1 and i + 1 then becomes adjacent. Return the
 * maximum coins you can collect by bursting the balloons wisely.
 * 
 * Sample Input:
 * 4
 * 3 1 5 8
 * Sample Output:
 * Max Coins: 167 (3*1*5 + 3*5*8 + 1*3*8 + 1*8*1)
 * 
 * Sample Input:
 * 2
 * 1 5
 * Sample Output:
 * Max Coins: 10
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(i, j) is max coins by bursting balloons in range [i, j].
 * 
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 */
public class BurstBalloons_TopDown {
    private static int[][] memo;

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

        memo = new int[n + 2][n + 2];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Max Coins: " + solve(nums, 1, n));
        sc.close();
    }

    private static int solve(int[] nums, int i, int j) {
        if (i > j)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];

        int maxCoins = 0;
        // Assume balloon k is the LAST to be burst in range [i, j]
        for (int k = i; k <= j; k++) {
            int current = nums[i - 1] * nums[k] * nums[j + 1];
            int left = solve(nums, i, k - 1);
            int right = solve(nums, k + 1, j);
            maxCoins = Math.max(maxCoins, current + left + right);
        }

        memo[i][j] = maxCoins;
        return maxCoins;
    }
}
