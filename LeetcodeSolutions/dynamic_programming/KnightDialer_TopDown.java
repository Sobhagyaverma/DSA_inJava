package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 28: Knight Dialer (LeetCode 935)
 * 
 * Problem Statement:
 * Given an integer n, return how many distinct phone numbers of length n we can
 * dial.
 * You are allowed to place the knight on any numeric cell initially and then
 * you should perform n - 1 jumps
 * to distinct cells to choose the next digits of the phone number.
 * 
 * Sample Input:
 * 1
 * Sample Output:
 * Phone Numbers: 10
 * 
 * Sample Input:
 * 2
 * Sample Output:
 * Phone Numbers: 20
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class KnightDialer_TopDown {
    private static int[][] memo;
    private static final int MOD = 1000000007;
    private static final int[][] neighbors = {
            { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 },
            {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 2, 4 }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Numbers: 10");
        } else {
            memo = new int[n + 1][10];
            for (int[] row : memo)
                Arrays.fill(row, -1);

            long count = 0;
            for (int i = 0; i < 10; i++) {
                count = (count + solve(n - 1, i)) % MOD;
            }
            System.out.println("Numbers: " + count);
        }
        sc.close();
    }

    private static int solve(int n, int digit) {
        if (n == 0)
            return 1;
        if (memo[n][digit] != -1)
            return memo[n][digit];

        long count = 0;
        for (int neighbor : neighbors[digit]) {
            count = (count + solve(n - 1, neighbor)) % MOD;
        }

        memo[n][digit] = (int) count;
        return memo[n][digit];
    }
}
