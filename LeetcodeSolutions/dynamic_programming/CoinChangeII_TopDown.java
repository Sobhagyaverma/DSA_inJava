package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

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
 * Ways: 4 (5, 2+2+1, 2+1+1+1, 1+1+1+1+1)
 * 
 * Sample Input:
 * 3
 * 1
 * 2
 * Sample Output:
 * Ways: 0
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(idx, amount) is the number of ways.
 * Transition: solve(idx, amount) = solve(idx, amount - coins[idx]) + solve(idx
 * - 1, amount)
 * 
 * Time Complexity: O(n * amount)
 * Space Complexity: O(n * amount) for memo.
 */
public class CoinChangeII_TopDown {
    private static int[][] memo;

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

        memo = new int[n][amount + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Ways: " + solve(coins, n - 1, amount));
        sc.close();
    }

    private static int solve(int[] coins, int idx, int amount) {
        if (amount == 0)
            return 1;
        if (idx < 0)
            return 0;
        if (memo[idx][amount] != -1)
            return memo[idx][amount];

        // Option 1: Pick the current coin (if possible)
        int pick = 0;
        if (coins[idx] <= amount) {
            pick = solve(coins, idx, amount - coins[idx]);
        }
        // Option 2: Skip current coin
        int skip = solve(coins, idx - 1, amount);

        memo[idx][amount] = pick + skip;
        return memo[idx][amount];
    }
}
