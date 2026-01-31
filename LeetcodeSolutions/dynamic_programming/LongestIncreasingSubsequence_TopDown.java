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
 * 8
 * 10 9 2 5 3 7 101 18
 * Sample Output:
 * LIS: 4 (2, 3, 7, 18)
 * 
 * Sample Input:
 * 6
 * 0 1 0 3 2 3
 * Sample Output:
 * LIS: 4
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(idx, prevIdx) where prevIdx is index of previous element in LIS.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2) for memo.
 */
public class LongestIncreasingSubsequence_TopDown {
    private static int[][] memo;

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

        // prevIdx is -1 initially, we map it to 0 and shift others by 1 for memo.
        memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("LIS: " + solve(nums, 0, -1));
        sc.close();
    }

    private static int solve(int[] nums, int idx, int prevIdx) {
        if (idx == nums.length)
            return 0;
        if (memo[idx][prevIdx + 1] != -1)
            return memo[idx][prevIdx + 1];

        // Option 1: Don't take current element
        int res = solve(nums, idx + 1, prevIdx);

        // Option 2: Take current element (if increasing)
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            res = Math.max(res, 1 + solve(nums, idx + 1, idx));
        }

        memo[idx][prevIdx + 1] = res;
        return res;
    }
}
