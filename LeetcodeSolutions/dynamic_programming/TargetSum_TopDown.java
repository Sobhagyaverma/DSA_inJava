package dynamic_programming;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 8: Target Sum (LeetCode 494)
 * 
 * Problem Statement:
 * You are given an integer array nums and an integer target. You want to build
 * an expression out of nums by
 * adding one of the symbols '+' and '-' before each integer in nums and then
 * concatenate all the integers.
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 * 
 * Sample Input:
 * 5
 * 1 1 1 1 1
 * 3
 * Sample Output:
 * Ways: 5
 * 
 * Sample Input:
 * 1
 * 1
 * 1
 * Sample Output:
 * Ways: 1
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(idx, currentSum)
 * 
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 */
public class TargetSum_TopDown {
    private static Map<String, Integer> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        memo = new HashMap<>();
        System.out.println("Ways: " + solve(nums, 0, 0, target));
        sc.close();
    }

    private static int solve(int[] nums, int idx, int currentSum, int target) {
        if (idx == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = idx + "," + currentSum;
        if (memo.containsKey(key))
            return memo.get(key);

        int add = solve(nums, idx + 1, currentSum + nums[idx], target);
        int subtract = solve(nums, idx + 1, currentSum - nums[idx], target);

        memo.put(key, add + subtract);
        return add + subtract;
    }
}
