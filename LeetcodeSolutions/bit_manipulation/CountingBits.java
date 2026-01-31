package bit_manipulation;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 6: Counting Bits (LeetCode 338)
 * 
 * Problem Statement:
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * 
 * Sample Input:
 * 2
 * Sample Output:
 * [0, 1, 1] (0:0, 1:1, 2:10)
 * 
 * Sample Input:
 * 5
 * Sample Output:
 * [0, 1, 1, 2, 1, 2] (0:0, 1:1, 2:10, 3:11, 4:100, 5:101)
 * 
 * Approach: Dynamic Programming + Bitwise
 * Relation: bits[i] = bits[i / 2] + (i % 2)
 * Or: bits[i] = bits[i >> 1] + (i & 1)
 * Time Complexity: O(n)
 * Space Complexity: O(n) for output array
 */
public class CountingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        System.out.println("Counts: " + Arrays.toString(ans));
        sc.close();
    }
}
