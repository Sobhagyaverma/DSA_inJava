package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 15: Delete and Earn (LeetCode 740)
 * 
 * Problem Statement:
 * Given an integer array nums, maximize points. If you take nums[i], you must
 * delete all nums[i]-1 and nums[i]+1.
 * 
 * Sample Input:
 * 3
 * 3 4 2
 * Sample Output:
 * Max Points: 6
 * 
 * Sample Input:
 * 5
 * 2 2 3 3 3
 * Sample Output:
 * Max Points: 9
 * 
 * Approach: Bottom-Up (Tabulation)
 * Logic: Reduces to House Robber. If we take number i, we can't take i-1.
 * 
 * Time Complexity: O(n + maxVal)
 * Space Complexity: O(maxVal)
 */
public class DeleteAndEarn_BottomUp {
    private static final int MAX = 10001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] counts = new int[MAX];
        int maxVal = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            counts[val]++;
            maxVal = Math.max(maxVal, val);
        }

        if (maxVal == 0) {
            System.out.println("Max Points: 0");
        } else {
            int[] dp = new int[maxVal + 1];
            dp[1] = counts[1];
            for (int i = 2; i <= maxVal; i++) {
                dp[i] = Math.max(dp[i - 1], (i * counts[i]) + dp[i - 2]);
            }
            System.out.println("Max Points: " + dp[maxVal]);
        }
        sc.close();
    }
}
