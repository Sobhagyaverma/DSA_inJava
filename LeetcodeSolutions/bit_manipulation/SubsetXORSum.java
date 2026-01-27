package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 11: Subset XOR Sum
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * Sum of all subset XOR totals.
 * 
 * Approach: Mathematical Observation
 * If we look at the kth bit, if at least one number has the kth bit set, then
 * exactly 2^(n-1) subsets will have that bit set in their XOR total.
 * So the result is (OR of all elements) * 2^(n-1).
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SubsetXORSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int orResult = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            orResult |= sc.nextInt();
        }

        // Sum = orResult * 2^(n-1)
        long result = (long) orResult * (1L << (n - 1));
        System.out.println("Total XOR Sum of all Subsets: " + result);
        sc.close();
    }
}
