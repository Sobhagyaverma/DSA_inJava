package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 20: Regular Expression Matching (LeetCode 10)
 * 
 * Problem Statement:
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*'.
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 
 * Sample Input:
 * aa a*
 * Sample Output:
 * Match: true
 * 
 * Sample Input:
 * ab .*
 * Sample Output:
 * Match: true
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class RegularExpressionMatching_TopDown {
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

        boolean firstMatch = (i < s.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean res;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Skip '*' and preceding char
            // Choice 2: Use '*' if first char matches
            res = solve(s, p, i, j + 2) || (firstMatch && solve(s, p, i + 1, j));
        } else {
            res = firstMatch && solve(s, p, i + 1, j + 1);
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
