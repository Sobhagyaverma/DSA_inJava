package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 18: Interleaving String (LeetCode 97)
 * 
 * Problem Statement:
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
 * s1 and s2.
 * 
 * Sample Input:
 * aabcc dbbca aadbbcbcac
 * Sample Output:
 * Interleaving: true
 * 
 * Sample Input:
 * aabcc dbbca aadbbbaccc
 * Sample Output:
 * Interleaving: false
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * State: solve(i, j) is boolean for s1[i...] and s2[j...] interleaving
 * s3[i+j...].
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class InterleavingString_TopDown {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s1: ");
        String s1 = sc.next();
        System.out.print("Enter s2: ");
        String s2 = sc.next();
        System.out.print("Enter s3: ");
        String s3 = sc.next();

        if (s1.length() + s2.length() != s3.length()) {
            System.out.println("Interleave: false");
        } else {
            memo = new int[s1.length() + 1][s2.length() + 1];
            for (int[] row : memo)
                Arrays.fill(row, -1);
            System.out.println("Interleave: " + solve(s1, s2, s3, 0, 0));
        }
        sc.close();
    }

    private static boolean solve(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        boolean res = false;
        int k = i + j;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = solve(s1, s2, s3, i + 1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = solve(s1, s2, s3, i, j + 1);
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
