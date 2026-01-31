package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 2: Single Number II (LeetCode 137)
 * 
 * Problem Statement:
 * Given an integer array nums where every element appears three times except
 * for one, which appears exactly once.
 * Find the single element and return it.
 * 
 * Sample Input:
 * 4
 * 2 2 3 2
 * Sample Output:
 * Result: 3
 * 
 * Sample Input:
 * 7
 * 0 1 0 1 0 1 99
 * Sample Output:
 * Result: 99
 * 
 * Approach: Bit Counting
 * We count the set bits at each of the 32 bit positions. Bits that are part of
 * numbers appearing 3 times
 * will have a sum divisible by 3. The remainder gives the bits of the single
 * number.
 * Time Complexity: O(32 * n) -> O(n)
 * Space Complexity: O(1)
 */
public class SingleNumberII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1)
                    sum++;
            }
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }
        System.out.println("Single Number II: " + result);
        sc.close();
    }
}
