package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 3: Two Single Numbers (LeetCode 260)
 * 
 * Problem Statement:
 * Given an integer array nums, in which exactly two elements appear only once
 * and all the other
 * elements appear exactly twice. Find the two elements that appear only once.
 * You can return the answer in any order.
 * 
 * Sample Input:
 * 6
 * 1 2 1 3 2 5
 * Sample Output:
 * Single Numbers: 3, 5
 * 
 * Sample Input:
 * 4
 * -1 0 -1 -2
 * Sample Output:
 * Single Numbers: 0, -2
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
