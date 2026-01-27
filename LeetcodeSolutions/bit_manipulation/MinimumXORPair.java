package bit_manipulation;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem 13: Minimum XOR Pair
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * Minimum XOR value between any two elements.
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
