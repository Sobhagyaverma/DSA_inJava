package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 21: Wildcard Matching (LeetCode 44)
 * 
 * Problem Statement:
 * Given an input string s and a pattern p, implement wildcard pattern matching
 * with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * Sample Input:
 * aa *
 * Sample Output:
 * Match: true
 * 
 * Sample Input:
 * cb ?a
 * Sample Output:
 * Match: false
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class WildcardMatching_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.next();
        System.out.print("Enter pattern p: ");
        String p = sc.next();

        memo = new int[s.length() + 1][p.length() + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Match: " + solve(s, p, 0, 0));
        sc.close();
    }

    private static boolean solve(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length();
        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        boolean res;
        if (i < s.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
            res = solve(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            // Choice 1: '*' matches empty sequence
            // Choice 2: '*' matches one char and we continue using '*'
            res = solve(s, p, i, j + 1) || (i < s.length() && solve(s, p, i + 1, j));
        } else {
            res = false;
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
