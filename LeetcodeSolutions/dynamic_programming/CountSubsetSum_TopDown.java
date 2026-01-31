package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 29: Count Subsets with Sum K (GFG)
 * 
 * Problem Statement:
 * Given an array arr of non-negative integers and an integer sum, count all
 * subsets of the given array with a sum equal to a given sum.
 * 
 * Sample Input:
 * 6
 * 3 3 3 3 3 3
 * 6
 * Sample Output:
 * Subsets: 15
 * 
 * Sample Input:
 * 4
 * 1 2 3 3
 * 6
 * Sample Output:
 * Subsets: 3
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(n * K)
 * Space Complexity: O(n * K)
 */
public class CountSubsetSum_TopDown {
    private static int[][] memo;
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

        // Sort to handle potential zero values correctly (though optional with correct
        // base cases)
        memo = new int[n][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Count: " + solve(nums, n - 1, k));
        sc.close();
    }

    private static int solve(int[] nums, int idx, int k) {
        // Base cases
        if (k == 0)
            return 1;
        if (idx < 0)
            return 0;
        if (memo[idx][k] != -1)
            return memo[idx][k];

        int pick = 0;
        if (nums[idx] <= k) {
            pick = solve(nums, idx - 1, k - nums[idx]);
        }
        int skip = solve(nums, idx - 1, k);

        memo[idx][k] = (pick + skip) % MOD;
        return memo[idx][k];
    }
}
