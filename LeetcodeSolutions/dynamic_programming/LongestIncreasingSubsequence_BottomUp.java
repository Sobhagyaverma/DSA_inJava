package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 9: Longest Increasing Subsequence (LeetCode 300)
 * 
 * Problem Statement:
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * Sample Input:
 * 6
 * 7 7 7 7 7 7
 * Sample Output:
 * LIS: 1
 * 
 * Sample Input:
 * 4
 * 0 1 2 3
 * Sample Output:
 * LIS: 4
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i] is the length of LIS ending at index i.
 * Transition: dp[i] = 1 + max(dp[j]) for j < i and nums[j] < nums[i].
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LongestIncreasingSubsequence_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("LIS: 0");
            sc.close();
            return;
        }
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        System.out.println("LIS: " + maxLIS);
        sc.close();
    }
}
