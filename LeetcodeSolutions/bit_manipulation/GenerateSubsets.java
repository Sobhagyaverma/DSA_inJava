package bit_manipulation;

import java.util.*;

/**
 * Problem 7: Generate All Subsets (Power Set) (LeetCode 78)
 * 
 * Problem Statement:
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Sample Input:
 * 3
 * 1 2 3
 * Sample Output:
 * [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 * 
 * Sample Input:
 * 1
 * 0
 * Sample Output:
 * [[], [0]]
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
