package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 1: Climbing Stairs (LeetCode 70)
 * 
 * Problem Statement:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Sample Input:
 * 2
 * Sample Output:
 * Ways: 2
 * 
 * Sample Input:
 * 5
 * Sample Output:
 * Ways: 8
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i] is the number of ways to reach step i.
 * Transition: dp[i] = dp[i-1] + dp[i-2]
 * Base Cases: dp[0] = 1, dp[1] = 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) - can be optimized to O(1) by using two variables.
 */
public class ClimbingStairs_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Ways: 0");
        } else if (n <= 1) {
            System.out.println("Ways: 1");
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println("Ways: " + dp[n]);
        }
        sc.close();
    }
}
