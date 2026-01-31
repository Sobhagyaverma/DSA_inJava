package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 2: House Robber (LeetCode 198)
 * 
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed,
 * and the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected.
 * 
 * Sample Input:
 * 4
 * 1 2 3 1
 * Sample Output:
 * Max Money: 4
 * 
 * Sample Input:
 * 5
 * 2 7 9 3 1
 * Sample Output:
 * Max Money: 12
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(idx) is the max money from house 0 up to idx.
 * Transition: solve(idx) = max(nums[idx] + solve(idx-2), solve(idx-1))
 * Base Cases: if idx < 0 return 0; if idx == 0 return nums[0];
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for memo and stack.
 */
public class HouseRobber_TopDown {
    private static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Max Money: 0");
            sc.close();
            return;
        }

        int[] nums = new int[n];
        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println("Max Money: " + solve(nums, n - 1));
        sc.close();
    }

    private static int solve(int[] nums, int idx) {
        if (idx < 0)
            return 0;
        if (idx == 0)
            return nums[0];
        if (memo[idx] != -1)
            return memo[idx];

        // Choice 1: Rob current house, then look at house idx-2
        int rob = nums[idx] + solve(nums, idx - 2);
        // Choice 2: Don't rob current house, look at house idx-1
        int skip = solve(nums, idx - 1);

        memo[idx] = Math.max(rob, skip);
        return memo[idx];
    }
}
