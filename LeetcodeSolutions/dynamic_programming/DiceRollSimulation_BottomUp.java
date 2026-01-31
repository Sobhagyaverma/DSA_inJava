package dynamic_programming;

import java.util.Scanner;

/**
 * Problem 27: Dice Roll Simulation (LeetCode 1223)
 * 
 * Problem Statement:
 * Given n and rollMax, count sequences without exceeding limits.
 * 
 * Sample Input:
 * 2
 * 1 1 1 1 1 1
 * Sample Output:
 * Total Sequences: 30
 * 
 * Sample Input:
 * 5
 * 10 10 10 10 10 10
 * Sample Output:
 * Total Sequences: 7776 (6^5)
 * 
 * Approach: Bottom-Up (Tabulation)
 * State: dp[i][j][k] is number of sequences of length i ending with face j with
 * streak k.
 * 
 * Time Complexity: O(n * 6 * 15)
 * Space Complexity: O(n * 6 * 15) - can be optimized.
 */
public class DiceRollSimulation_BottomUp {
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

        // dp[i][j][k]: i length, j face (0-5), k consecutive count (1-15)
        int[][][] dp = new int[n + 1][6][16];

        // Base case: length 1
        for (int j = 0; j < 6; j++) {
            dp[1][j][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) { // current face
                for (int p = 0; p < 6; p++) { // previous face
                    if (j != p) {
                        // All previous sequences ending with p can be followed by j
                        for (int k = 1; k <= 15; k++) {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][p][k]) % MOD;
                        }
                    } else {
                        // Sequence ending with j followed by another j (if within rollMax)
                        for (int k = 1; k < rollMax[j]; k++) {
                            dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % MOD;
                        }
                    }
                }
            }
        }

        long total = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= 15; k++) {
                total = (total + dp[n][j][k]) % MOD;
            }
        }

        System.out.println("Sequences: " + total);
        sc.close();
    }
}
