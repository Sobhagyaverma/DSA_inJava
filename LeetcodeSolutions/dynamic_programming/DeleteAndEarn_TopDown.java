package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 15: Delete and Earn (LeetCode 740)
 * 
 * Problem Statement:
 * You are given an integer array nums. You want to maximize the number of
 * points you get by performing the following operation
 * any number of times: Pick any nums[i] and delete it to earn nums[i] points.
 * Afterwards, you must delete every element equal to nums[i] - 1 and every
 * element equal to nums[i] + 1.
 * 
 * Sample Input:
 * 3
 * 3 4 2
 * Sample Output:
 * Max Points: 6 (Delete 4 to earn 4, delete 3, remaining 2, delete 2 to earn 2,
 * total 6)
 * 
 * Sample Input:
 * 6
 * 2 2 3 3 3 4
 * Sample Output:
 * Max Points: 9
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * Logic: Reduces to House Robber. If we take all occurrences of x, we can't
 * take x-1 or x+1.
 * 
 * Time Complexity: O(n + maxVal)
 * Space Complexity: O(maxVal)
 */
public class DeleteAndEarn_TopDown {
    private static int[] memo;
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

        memo = new int[maxVal + 1];
        Arrays.fill(memo, -1);

        System.out.println("Max Points: " + solve(counts, maxVal));
        sc.close();
    }

    private static int solve(int[] counts, int i) {
        if (i <= 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        // Choice 1: Earn points from number i
        int earn = (i * counts[i]) + solve(counts, i - 2);
        // Choice 2: Skip number i
        int skip = solve(counts, i - 1);

        memo[i] = Math.max(earn, skip);
        return memo[i];
    }
}
