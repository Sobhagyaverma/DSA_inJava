package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 7: Partition Equal Subset Sum (LeetCode 416)
 * 
 * Problem Statement:
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * Sample Input:
 * 4
 * 1 2 3 5
 * Sample Output:
 * Can Partition: false
 * 
 * Sample Input:
 * 2
 * 1 1
 * Sample Output:
 * Can Partition: true
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[target] is boolean indicating if target sum is possible.
 * 
 * Time Complexity: O(n * totalSum)
 * Space Complexity: O(totalSum) - space optimized.
 */
public class PartitionEqualSubsetSum_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            System.out.println("Can Partition: false");
        } else {
            int targetSum = sum / 2;
            boolean[] dp = new boolean[targetSum + 1];
            dp[0] = true;

            for (int num : nums) {
                for (int j = targetSum; j >= num; j--) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
            System.out.println("Can Partition: " + dp[targetSum]);
        }
        sc.close();
    }
}
