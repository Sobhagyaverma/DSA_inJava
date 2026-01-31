package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 17: Check if XOR of All Subarrays Is Zero
 * 
 * Problem Statement:
 * Given an array of integers, check if the XOR sum of all its subarrays' XOR
 * totals is zero.
 * 
 * Sample Input:
 * 2
 * 1 2
 * Sample Output:
 * Result: true
 * 
 * Sample Input:
 * 3
 * 1 2 3
 * Sample Output:
 * Result: false
 * 
 * Approach: Frequency of indices
 * Reuse XOR of All Subarrays logic (Problem 15).
 * Time Complexity: O(n)
 */
public class IsXORAllSubarraysZero {
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
            long freq = (long) (i + 1) * (n - i);
            if (freq % 2 != 0)
                result ^= nums[i];
        }
        System.out.println("Is XOR of all subarrays zero? " + (result == 0));
        sc.close();
    }
}
