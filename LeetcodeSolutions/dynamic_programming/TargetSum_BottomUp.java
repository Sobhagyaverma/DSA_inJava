package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 8: Target Sum (LeetCode 494)
 * 
 * Problem Statement:
 * Given an integer array nums and an integer target, return the number of
 * different expressions that you can build which evaluate to target.
 * (Same as finding subsets with sum (target + totalSum) / 2).
 * 
 * Sample Input:
 * 5
 * 1 1 1 1 1
 * 3
 * Sample Output:
 * Ways: 5
 * 
 * Sample Input:
 * 2
 * 1 2
 * 3
 * Sample Output:
 * Ways: 1
 * 
 * Approach: Bottom-Up (Tabulation)
 * Logic: Subset1 - Subset2 = target => Subset1 = (target + totalSum) / 2.
 * Count subsets with sum = subset1_sum.
 * 
 * Time Complexity: O(n * sum)
 * Space Complexity: O(sum)
 */
public class TargetSum_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int totalSum = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            totalSum += nums[i];
        }
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Edge case: target is too large or (target + totalSum) is odd
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) {
            System.out.println("Ways: 0");
        } else {
            int subsetSum = (target + totalSum) / 2;
            int[] dp = new int[subsetSum + 1];
            dp[0] = 1;

            for (int num : nums) {
                for (int j = subsetSum; j >= num; j--) {
                    dp[j] += dp[j - num];
                }
            }
            System.out.println("Ways: " + dp[subsetSum]);
        }
        sc.close();
    }
}
