package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 27: Dice Roll Simulation (LeetCode 1223)
 * 
 * Problem Statement:
 * A die simulator generates a random number from 1 to 6 for each roll. There is
 * a constraint that a die cannot roll
 * the face i more than rollMax[i] consecutive times. Given an integer n and an
 * array rollMax,
 * return the number of distinct sequences that can be obtained.
 * 
 * Sample Input:
 * 2
 * 1 1 2 2 2 3
 * Sample Output:
 * Total Sequences: 34
 * 
 * Sample Input:
 * 3
 * 1 1 1 2 2 3
 * Sample Output:
 * Total Sequences: 181
 * 
 * Approach: Top-Down (Recursion + Memoization)
 * 
 * Time Complexity: O(n * 6 * 15)
 * Space Complexity: O(n * 6 * 15)
 */
public class DiceRollSimulation_TopDown {
    private static int[][][] memo;
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] rollMax = new int[6];
        System.out.println("Enter rollMax for 6 faces:");
        for (int i = 0; i < 6; i++) {
            rollMax[i] = sc.nextInt();
        }

        // face 0-5, streak 1-15, mapping face 6 to "none"
        memo = new int[n + 1][7][16];
        for (int[][] surface : memo) {
            for (int[] row : surface)
                Arrays.fill(row, -1);
        }

        System.out.println("Sequences: " + solve(n, 6, 0, rollMax));
        sc.close();
    }

    private static int solve(int n, int lastFace, int streak, int[] rollMax) {
        if (n == 0)
            return 1;
        if (memo[n][lastFace][streak] != -1)
            return memo[n][lastFace][streak];

        long count = 0;
        for (int face = 0; face < 6; face++) {
            if (face == lastFace) {
                if (streak < rollMax[face]) {
                    count = (count + solve(n - 1, face, streak + 1, rollMax)) % MOD;
                }
            } else {
                count = (count + solve(n - 1, face, 1, rollMax)) % MOD;
            }
        }

        memo[n][lastFace][streak] = (int) count;
        return memo[n][lastFace][streak];
    }
}
