package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 25: Russian Doll Envelopes (LeetCode 354)
 * 
 * Problem Statement:
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
 * represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of
 * one envelope are greater than the other.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one
 * inside another).
 * 
 * Sample Input:
 * 4
 * 5 4
 * 6 4
 * 6 7
 * 2 3
 * Sample Output:
 * Max Envelopes: 3 ([2,3] -> [5,4] -> [6,7])
 * 
 * Sample Input:
 * 3
 * 1 1
 * 1 1
 * 1 1
 * Sample Output:
 * Max Envelopes: 1
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * Logic: Sort width ascending, height descending. Find LIS on heights.
 * 
 * Time Complexity: O(n^2) for memoization LIS.
 * Space Complexity: O(n^2)
 */
public class RussianDollEnvelopes_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] envelopes = new int[n][2];
        System.out.println("Enter width and height for each envelope:");
        for (int i = 0; i < n; i++) {
            envelopes[i][0] = sc.nextInt();
            envelopes[i][1] = sc.nextInt();
        }

        // Sort: W ascending, H descending (to avoid same width being counted)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] heights = new int[n];
        for (int i = 0; i < n; i++)
            heights[i] = envelopes[i][1];

        memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Max Envelopes: " + solve(heights, 0, -1));
        sc.close();
    }

    private static int solve(int[] nums, int idx, int prevIdx) {
        if (idx == nums.length)
            return 0;
        if (memo[idx][prevIdx + 1] != -1)
            return memo[idx][prevIdx + 1];

        int res = solve(nums, idx + 1, prevIdx);
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            res = Math.max(res, 1 + solve(nums, idx + 1, idx));
        }

        memo[idx][prevIdx + 1] = res;
        return res;
    }
}
