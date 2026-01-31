package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 16: Arithmetic Slices (LeetCode 413)
 * 
 * Problem Statement:
 * An integer array is called arithmetic if it consists of at least three
 * elements and if the difference
 * between any two consecutive elements is the same. Return the number of
 * arithmetic subarrays.
 * 
 * Sample Input:
 * 4
 * 1 2 3 4
 * Sample Output:
 * Total Slices: 3 ([1,2,3], [2,3,4], [1,2,3,4])
 * 
 * Sample Input:
 * 1
 * 1
 * Sample Output:
 * Total Slices: 0
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ArithmeticSlices_TopDown {
    private static int[] memo;
    private static int totalSlices = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println("Arithmetic Slices: 0");
            sc.close();
            return;
        }

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        memo = new int[n];
        Arrays.fill(memo, -1);

        // Calculate for each end position
        for (int i = 2; i < n; i++) {
            totalSlices += solve(nums, i);
        }

        System.out.println("Arithmetic Slices: " + totalSlices);
        sc.close();
    }

    private static int solve(int[] nums, int i) {
        if (i < 2)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        int res = 0;
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            res = 1 + solve(nums, i - 1);
        }

        memo[i] = res;
        return res;
    }
}
