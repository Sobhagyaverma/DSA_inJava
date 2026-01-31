package bit_manipulation;

import java.util.Scanner;

/**
 * Problem 5: Find the Duplicate Number (LeetCode 287)
 * 
 * Problem Statement:
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * 
 * Sample Input:
 * 5
 * 1 3 4 2 2
 * Sample Output:
 * Duplicate: 2
 * 
 * Sample Input:
 * 5
 * 3 1 3 4 2
 * Sample Output:
 * Duplicate: 3
 * 
 * Approach: Bit Counting
 * For each bit from 0 to 31, count how many numbers in [1, n] have that bit
 * set,
 * and how many numbers in the input array have that bit set.
 * If the count in the array is greater, the duplicate number must have that bit
 * set.
 * Time Complexity: O(32 * n) -> O(n)
 * Space Complexity: O(1)
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (range 1 to n): ");
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        System.out.println("Enter " + (n + 1) + " elements:");
        for (int i = 0; i <= n; i++)
            nums[i] = sc.nextInt();

        int duplicate = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (1 << i);
            int countRange = 0;
            int countArray = 0;
            for (int k = 1; k <= n; k++) {
                if ((k & bit) != 0)
                    countRange++;
            }
            for (int num : nums) {
                if ((num & bit) != 0)
                    countArray++;
            }
            if (countArray > countRange) {
                duplicate |= bit;
            }
        }
        System.out.println("Duplicate Number: " + duplicate);
        sc.close();
    }
}
