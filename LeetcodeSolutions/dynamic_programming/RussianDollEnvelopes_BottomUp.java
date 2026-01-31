package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 25: Russian Doll Envelopes (LeetCode 354)
 * 
 * Problem Statement:
 * Given a 2D array of integers envelopes where envelopes[i] = [wi, hi], return
 * the maximum number
 * of envelopes you can Russian doll (i.e., put one inside another).
 * 
 * Sample Input:
 * 4
 * 5 4
 * 6 4
 * 6 7
 * 2 3
 * Sample Output:
 * Max Envelopes: 3
 * 
 * Sample Input:
 * 1
 * 1 1
 * Sample Output:
 * Max Envelopes: 1
 * 
 * Approach: Bottom-Up (Tabulation with Binary Search)
 * State: Typical LIS array logic.
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class RussianDollEnvelopes_BottomUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Max Envelopes: 0");
            sc.close();
            return;
        }

        int[][] envelopes = new int[n][2];
        System.out.println("Enter width and height for each envelope:");
        for (int i = 0; i < n; i++) {
            envelopes[i][0] = sc.nextInt();
            envelopes[i][1] = sc.nextInt();
        }

        // Sort: W ascending, H descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        // LIS on heights using binary search approach
        int[] tails = new int[n];
        int size = 0;
        for (int[] env : envelopes) {
            int h = env[1];
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < h)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = h;
            if (i == size)
                size++;
        }

        System.out.println("Max Envelopes: " + size);
        sc.close();
    }
}
