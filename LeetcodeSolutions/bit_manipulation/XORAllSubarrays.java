package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 15: XOR of All Subarrays
 * 
 * Problem Statement:
 * Given an array of integers, find the XOR of all XOR totals of all contiguous
 * subarrays.
 * 
 * Sample Input:
 * 3
 * 1 2 3
 * Sample Output:
 * Total XOR: 2 (Subarrays: [1], [2], [3], [1,2], [2,3], [1,2,3]. XORs:
 * 1,2,3,3,1,0. Total: 1^2^3^3^1^0 = 2)
 * 
 * Sample Input:
 * 2
 * 1 2
 * Sample Output:
 * Total XOR: 0 (Subarrays: [1], [2], [1,2]. XORs: 1, 2, 3. Total: 1^2^3 = 0)
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
