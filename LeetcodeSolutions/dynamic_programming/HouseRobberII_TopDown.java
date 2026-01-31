package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 3: House Robber II (LeetCode 213)
 * 
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one.
 * 
 * Sample Input:
 * 3
 * 2 3 2
 * Sample Output:
 * Max Money: 3
 * 
 * Sample Input:
 * 4
 * 1 2 3 1
 * Sample Output:
 * Max Money: 4
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * Logic: Circular houses. Max of robbing houses 0 to n-2 or 1 to n-1.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for memo and stack.
 */
public class HouseRobberII_TopDown {
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

        if (n == 1) {
            System.out.println("Max Money: " + nums[0]);
        } else {
            // Case 1: Rob houses 0 to n-2
            memo = new int[n];
            Arrays.fill(memo, -1);
            int case1 = solve(nums, 0, n - 2);

            // Case 2: Rob houses 1 to n-1
            memo = new int[n];
            Arrays.fill(memo, -1);
            int case2 = solve(nums, 1, n - 1);

            System.out.println("Max Money: " + Math.max(case1, case2));
        }
        sc.close();
    }

    private static int solve(int[] nums, int start, int idx) {
        if (idx < start)
            return 0;
        if (idx == start)
            return nums[start];
        if (memo[idx] != -1)
            return memo[idx];

        int rob = nums[idx] + solve(nums, start, idx - 2);
        int skip = solve(nums, start, idx - 1);

        memo[idx] = Math.max(rob, skip);
        return memo[idx];
    }
}
