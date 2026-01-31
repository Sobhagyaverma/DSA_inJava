package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 29: Count Subsets with Sum K (GFG)
 * 
 * Problem Statement:
 * Count all subsets of a given array with a sum equal to a given sum.
 * 
 * Sample Input:
 * 4
 * 1 2 3 3
 * 6
 * Sample Output:
 * Subsets: 3
 * 
 * Sample Input:
 * 3
 * 1 1 1
 * 2
 * Sample Output:
 * Subsets: 3
 * 
 * Approach: Bottom-Up (Tabulation)
 * 
 * Time Complexity: O(n * K)
 * Space Complexity: O(K) - space optimized.
 */
public class CountSubsetSum_BottomUp {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target K: ");
        int k = sc.nextInt();

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = k; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }

        System.out.println("Count: " + dp[k]);
        sc.close();
    }
}
