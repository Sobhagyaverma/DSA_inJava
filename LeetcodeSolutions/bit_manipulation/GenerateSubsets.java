package bit_manipulation;

import java.util.*;

/**
 * Problem 7: Generate All Subsets (Power Set)
 * 
 * Input Format:
 * n, then n array elements.
 * 
 * Output Format:
 * List of all possible subsets.
 * 
 * Approach: Iteration using Bitmask
 * A set of size n has 2^n subsets. We iterate from 0 to (2^n - 1).
 * If the kth bit of the iterator is set, include nums[k] in the current subset.
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(2^n * n) for storing result
 */
public class GenerateSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        int powerSetSize = (1 << n);

        for (int i = 0; i < powerSetSize; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        System.out.println("Power Set: " + result);
        sc.close();
    }
}
