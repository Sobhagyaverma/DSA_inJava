package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 25: Find Maximum AND Pair
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * Maximum value of (nums[i] & nums[j]) for any pair.
 * 
 * Approach: Bitwise Greedy
 * We try to set bits of the result from MSB (31) to LSB (0).
 * For each position, check if there are at least two numbers having the
 * currently formed prefix.
 * Time Complexity: O(32 * n)
 * Space Complexity: O(1)
 */
public class MaximumANDPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // Check if we can have the current res set with i-th bit as 1
            int count = countMatchingPrefix(nums, res | (1 << i));
            if (count >= 2) {
                res |= (1 << i);
            }
        }
        System.out.println("Maximum AND Pair: " + res);
        sc.close();
    }

    private static int countMatchingPrefix(int[] nums, int pattern) {
        int count = 0;
        for (int num : nums) {
            if ((num & pattern) == pattern)
                count++;
        }
        return count;
    }
}
