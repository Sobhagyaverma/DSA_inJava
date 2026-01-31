package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 12: Distinct Subsequences (LeetCode 115)
 * 
 * Problem Statement:
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * Sample Input:
 * rabbbit rabbit
 * Sample Output:
 * Ways: 3
 * 
 * Sample Input:
 * babgbag bag
 * Sample Output:
 * Ways: 5
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(i, j) = how many ways to pick t[0...j] from s[0...i].
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class DistinctSubsequences_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.next();
        System.out.print("Enter string t: ");
        String t = sc.next();

        int m = s.length();
        int n = t.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Distinct Subsequences: " + solve(s, t, m - 1, n - 1));
        sc.close();
    }

    private static int solve(String s, String t, int i, int j) {
        // If we ran out of characters in t, we found 1 valid subsequence
        if (j < 0)
            return 1;
        // If we ran out of characters in s but not in t, not possible
        if (i < 0)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            // Choice 1: Use s[i] to match t[j] + Choice 2: Don't use s[i] even if it
            // matches
            res = solve(s, t, i - 1, j - 1) + solve(s, t, i - 1, j);
        } else {
            // Must skip s[i]
            res = solve(s, t, i - 1, j);
        }

        memo[i][j] = res;
        return res;
    }
}
