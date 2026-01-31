package dynamic_programming;

import java.util.Scanner;

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
 * Combinations: 7
 * 
 * Sample Input:
 * 10
 * 2
 * 2 5
 * Sample Output:
 * Combinations: 3 ( (2,2,2,2,2), (5,5), (2,2,2,?) - no, actually (2,2,2,2,2),
 * (5,5), (?) )
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i] is the number of ways to reach sum i.
 * 
 * Time Complexity: O(n * target)
 * Space Complexity: O(target)
 */
public class CombinationSumIV_BottomUp {
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

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        System.out.println("Ways: " + dp[target]);
        sc.close();
    }
}
