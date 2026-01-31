package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 3: House Robber II (LeetCode 213)
 * 
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. First and last houses are
 * neighbors.
 * 
 * Sample Input:
 * 3
 * 2 3 2
 * Sample Output:
 * Max Money: 3
 * 
 * Sample Input:
 * 1
 * 7
 * Sample Output:
 * Max Money: 7
 * 
 * Approach: Bottom-Up (Tabulation)
 * Logic: Circular houses. Use tabulation for cases 0 to n-2 and 1 to n-1.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) - can be optimized to O(1).
 */
public class HouseRobberII_BottomUp {
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
            int case1 = robLinear(nums, 0, n - 2);
            int case2 = robLinear(nums, 1, n - 1);
            System.out.println("Max Money: " + Math.max(case1, case2));
        }
        sc.close();
    }

    private static int robLinear(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        if (start == end)
            return nums[start];

        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
