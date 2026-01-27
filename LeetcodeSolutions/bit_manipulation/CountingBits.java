package bit_manipulation;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 6: Counting Bits
 * 
 * Input Format:
 * An integer n.
 * 
 * Output Format:
 * An array of size n+1 where ans[i] is the number of 1s in the binary
 * representation of i.
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
