package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 4: Coin Change II (LeetCode 518)
 * 
 * Problem Statement:
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * 
 * Sample Input:
 * 5
 * 3
 * 1 2 5
 * Sample Output:
 * Ways: 4
 * 
 * Sample Input:
 * 3
 * 1
 * 2
 * Sample Output:
 * Ways: 0
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[j] is the number of ways to make amount j.
 * Transition: dp[j] += dp[j - coins[i]]
 * 
 * Time Complexity: O(n * amount)
 * Space Complexity: O(amount) - space optimized.
 */
public class CoinChangeII_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println("Ways: " + dp[amount]);
        sc.close();
    }
}
