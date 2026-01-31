package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 28: Knight Dialer (LeetCode 935)
 * 
 * Problem Statement:
 * Count distinct phone numbers of length n using a knight on a phone pad.
 * 
 * Sample Input:
 * 3
 * Sample Output:
 * Numbers: 46
 * 
 * Sample Input:
 * 4
 * Sample Output:
 * Numbers: 104
 * 
 * Approach: Bottom-Up (Tabulation)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) - space optimized.
 */
public class KnightDialer_BottomUp {
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
            long[] dp = new long[10];
            for (int i = 0; i < 10; i++)
                dp[i] = 1;

            for (int h = 1; h < n; h++) {
                long[] nextDp = new long[10];
                for (int i = 0; i < 10; i++) {
                    for (int neighbor : neighbors[i]) {
                        nextDp[neighbor] = (nextDp[neighbor] + dp[i]) % MOD;
                    }
                }
                dp = nextDp;
            }

            long total = 0;
            for (long val : dp)
                total = (total + val) % MOD;
            System.out.println("Numbers: " + total);
        }
        sc.close();
    }
}
