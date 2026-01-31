package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 17: Combination Sum IV (LeetCode 377)
 * 
 * Problem Statement:
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations
 * that add up to target. (Different sequences are counted as different
 * combinations).
 * 
 * Sample Input:
 * 4
 * 3
 * 1 2 3
 * Sample Output:
 * Combinations: 7 ( (1,1,1,1), (1,1,2), (1,2,1), (1,3), (2,1,1), (2,2), (3,1) )
 * 
 * Sample Input:
 * 3
 * 1
 * 9
 * Sample Output:
 * Combinations: 0
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(target) is the number of ways to reach target.
 * 
 * Time Complexity: O(n * target)
 * Space Complexity: O(target)
 */
public class CombinationSumIV_TopDown {
    private static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        memo = new int[target + 1];
        Arrays.fill(memo, -1);

        System.out.println("Ways: " + solve(nums, target));
        sc.close();
    }

    private static int solve(int[] nums, int target) {
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        if (memo[target] != -1)
            return memo[target];

        int res = 0;
        for (int num : nums) {
            res += solve(nums, target - num);
        }

        memo[target] = res;
        return res;
    }
}
