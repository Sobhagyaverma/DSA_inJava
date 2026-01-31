package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 2: House Robber (LeetCode 198)
 * 
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed.
 * Adjacent houses have security systems connected and it will automatically
 * contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Sample Input:
 * 4
 * 1 2 3 1
 * Sample Output:
 * Max Money: 4
 * 
 * Sample Input:
 * 3
 * 10 2 3
 * Sample Output:
 * Max Money: 13
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i] is the max money from first i houses.
 * Transition: dp[i] = max(nums[i] + dp[i-2], dp[i-1])
 * Base Case: dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) - can be optimized to O(1).
 */
public class HouseRobber_BottomUp {
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
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            System.out.println("Max Money: " + dp[n - 1]);
        }
        sc.close();
    }
}
