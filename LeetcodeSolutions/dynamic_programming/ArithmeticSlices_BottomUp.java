package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 16: Arithmetic Slices (LeetCode 413)
 * 
 * Problem Statement:
 * Given an integer array nums, return the number of arithmetic subarrays.
 * 
 * Sample Input:
 * 5
 * 1 2 3 8 9
 * Sample Output:
 * Total Slices: 1 ([1,2,3])
 * 
 * Sample Input:
 * 3
 * 1 1 1
 * Sample Output:
 * Total Slices: 1
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i] is the number of arithmetic slices ending at index i.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) - can be optimized to O(1).
 */
public class ArithmeticSlices_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println("Arithmetic Slices: 0");
            sc.close();
            return;
        }

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int total = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                total += dp[i];
            }
        }

        System.out.println("Arithmetic Slices: " + total);
        sc.close();
    }
}
