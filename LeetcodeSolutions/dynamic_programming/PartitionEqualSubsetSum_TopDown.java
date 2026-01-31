package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

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
 * 1 5 11 5
 * Sample Output:
 * Can Partition: true
 * 
 * Sample Input:
 * 3
 * 1 2 3
 * Sample Output:
 * Can Partition: true
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * Logic: Problem reduces to finding if a subset sum equals totalSum / 2.
 * State: solve(idx, target) is boolean.
 * 
 * Time Complexity: O(n * totalSum)
 * Space Complexity: O(n * totalSum) for memo.
 */
public class PartitionEqualSubsetSum_TopDown {
    private static int[][] memo;

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
            int target = sum / 2;
            memo = new int[n][target + 1];
            for (int[] row : memo)
                Arrays.fill(row, -1);
            System.out.println("Can Partition: " + (solve(nums, n - 1, target) == 1));
        }
        sc.close();
    }

    private static int solve(int[] nums, int idx, int target) {
        if (target == 0)
            return 1;
        if (idx < 0 || target < 0)
            return 0;
        if (memo[idx][target] != -1)
            return memo[idx][target];

        // Option 1: Include nums[idx]
        int include = solve(nums, idx - 1, target - nums[idx]);
        // Option 2: Exclude nums[idx]
        int exclude = solve(nums, idx - 1, target);

        memo[idx][target] = (include == 1 || exclude == 1) ? 1 : 0;
        return memo[idx][target];
    }
}
