package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 3: Two Single Numbers
 * 
 * Input Format:
 * Number of elements n, then n integers where every element appears twice
 * except for two elements.
 * 
 * Output Format:
 * The two numbers that appear only once.
 * 
 * Approach: XOR + Partitioning
 * 1. XOR all numbers. Result is x ^ y.
 * 2. Find the rightmost set bit in (x ^ y). This bit exists because x != y.
 * 3. Partition array into two groups based on this bit.
 * 4. XOR each group to find x and y.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TwoSingleNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int xorResult = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            xorResult ^= nums[i];
        }

        // Find rightmost set bit
        int rightmostSetBit = xorResult & -xorResult;

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        System.out.println("Two Single Numbers: " + x + " and " + y);
        sc.close();
    }
}
