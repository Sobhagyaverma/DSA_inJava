package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 23: Best Time to Buy and Sell Stock IV (LeetCode 188)
 * 
 * Problem Statement:
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 * 
 * Sample Input:
 * 2 3
 * 2 4 1
 * Sample Output:
 * Max Profit: 2 (Buy at 2, Sell at 4)
 * 
 * Sample Input:
 * 2 6
 * 3 2 6 5 0 3
 * Sample Output:
 * Max Profit: 7 (Buy at 2, Sell at 6, then Buy at 0, Sell at 3)
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(idx, k, holding)
 * 
 * Time Complexity: O(n * k)
 * Space Complexity: O(n * k)
 */
public class StockIV_TopDown {
    private static int[][][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        if (n <= 1 || k <= 0) {
            System.out.println("Max Profit: 0");
            sc.close();
            return;
        }

        // Optimization for very large k (unlimited transactions)
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            System.out.println("Max Profit: " + profit);
            sc.close();
            return;
        }

        memo = new int[n][k + 1][2];
        for (int[][] surface : memo) {
            for (int[] row : surface)
                Arrays.fill(row, -1);
        }

        System.out.println("Max Profit: " + solve(prices, 0, k, 0));
        sc.close();
    }

    private static int solve(int[] prices, int idx, int k, int holding) {
        if (idx == prices.length || k == 0)
            return 0;
        if (memo[idx][k][holding] != -1)
            return memo[idx][k][holding];

        int res;
        if (holding == 1) {
            // Choice 1: Sell
            int sell = prices[idx] + solve(prices, idx + 1, k - 1, 0);
            // Choice 2: Don't sell
            int keep = solve(prices, idx + 1, k, 1);
            res = Math.max(sell, keep);
        } else {
            // Choice 1: Buy
            int buy = -prices[idx] + solve(prices, idx + 1, k, 1);
            // Choice 2: Don't buy
            int skip = solve(prices, idx + 1, k, 0);
            res = Math.max(buy, skip);
        }

        memo[idx][k][holding] = res;
        return res;
    }
}
