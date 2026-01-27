package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 15: XOR of All Subarrays
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * XOR sum of the XOR totals of all possible contiguous subarrays.
 * 
 * Approach: Bit frequency / Counting occurrences
 * An element at index i (0-indexed) appears in exactly (i+1) * (n-i) subarrays.
 * If this count is odd, nums[i] contributes to the final XOR.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class XORAllSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++) {
            long frequency = (long) (i + 1) * (n - i);
            if (frequency % 2 != 0) {
                result ^= nums[i];
            }
        }
        System.out.println("Total XOR of all Subarrays: " + result);
        sc.close();
    }
}
