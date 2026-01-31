package dynamic_programming;

import java.util.*;

/**
 * Problem 23: Best Time to Buy and Sell Stock IV (LeetCode 188)
 * 
 * Problem Statement:
 * Maximize profit from stock prices with at most k transactions.
 * 
 * Sample Input:
 * 2 6
 * 3 3 5 0 0 3 1 4
 * Sample Output:
 * Max Profit: 6
 * 
 * Sample Input:
 * 0 3
 * 1 2 3
 * Sample Output:
 * Max Profit: 0
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][k][holding]
 * 
 * Time Complexity: O(n * k)
 * Space Complexity: O(k) - space optimized to O(k).
 */
public class StockIV_BottomUp {
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

        // dp[k][0] is max profit with k transactions left and NOT holding
        // dp[k][1] is max profit with k transactions left and holding
        int[][] dp = new int[k + 1][2];

        // Base case: holding on day 0
        for (int j = 0; j <= k; j++) {
            dp[j][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                // Not holding: max(wasn't holding, just sold)
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                // Holding: max(was holding, just bought)
                // Note: buying doesn't use a transaction, selling does (or vice versa)
                // Here, a transaction is completed on sell.
                dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
            }
        }

        // Standard 1D DP approach for stock k
        // buy[j]: max profit on day i with j transactions and holding a stock
        // sell[j]: max profit on day i with j transactions and not holding a stock
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, -prices[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        System.out.println("Max Profit: " + sell[k]);
        sc.close();
    }
}
