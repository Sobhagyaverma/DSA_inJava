package bit_manipulation;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 13: Minimum XOR Pair
 * 
 * Problem Statement:
 * Given an array of integers, find the minimum XOR value between any two
 * distinct elements in the array.
 * 
 * Sample Input:
 * 4
 * 1 2 3 4
 * Sample Output:
 * Min XOR: 1 (2 ^ 3 = 1)
 * 
 * Sample Input:
 * 3
 * 9 5 3
 * Sample Output:
 * Min XOR: 6 (5 ^ 3 = 6)
 * 
 * Approach: Sorting
 * The minimum XOR pair values are always adjacent in a sorted array.
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class MinimumXORPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);

        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            minXor = Math.min(minXor, nums[i] ^ nums[i + 1]);
        }
        System.out.println("Minimum XOR Pair: " + minXor);
        sc.close();
    }
}
