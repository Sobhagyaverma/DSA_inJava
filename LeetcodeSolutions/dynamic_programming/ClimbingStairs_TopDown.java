package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

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
 * Ways: 2 (1+1, 2)
 * 
 * Sample Input:
 * 3
 * Sample Output:
 * Ways: 3 (1+1+1, 1+2, 2+1)
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: findWays(i) is the number of ways to reach step i.
 * Transition: findWays(i) = findWays(i-1) + findWays(i-2)
 * Base Cases: findWays(0) = 1, findWays(1) = 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for memo array and recursion stack.
 */
public class ClimbingStairs_TopDown {
    private static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Ways: 0");
        } else {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            System.out.println("Ways: " + findWays(n));
        }
        sc.close();
    }

    private static int findWays(int n) {
        if (n <= 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];

        memo[n] = findWays(n - 1) + findWays(n - 2);
        return memo[n];
    }
}
