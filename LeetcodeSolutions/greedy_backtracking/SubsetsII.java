package greedy_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input Format:
- n (size)
- n integers (may have duplicates)

Output Format:
- List of unique subsets

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10

Sample Input:
3
1 2 2
Sample Output:
[], [1], [1, 2], [1, 2, 2], [2], [2, 2]
*/

public class SubsetsII {
    /**
     * Backtracking Approach with Pruning:
     * To avoid duplicate subsets, we first sort the array.
     * During the recursive search, at each level, if we encounter an element
     * that is identical to the previous element at the SAME level, we skip it.
     * 
     * Choice: Include nums[i].
     * Recursive Call: Move to i + 1.
     * Backtrack: Undo inclusion.
     * Pruning: if (i > start && nums[i] == nums[i-1]) continue;
     * 
     * Time Complexity: O(n * 2^n).
     * Space Complexity: O(n).
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to bring duplicates together
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Pruning: Skip duplicates at the same recursive level
            if (i > start && nums[i] == nums[i - 1])
                continue;

            // Choice
            tempList.add(nums[i]);

            // Recursive Call
            backtrack(result, tempList, nums, i + 1);

            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter elements (duplicates allowed):");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        SubsetsII obj = new SubsetsII();
        List<List<Integer>> result = obj.subsetsWithDup(nums);

        System.out.println("Unique subsets:");
        for (List<Integer> s : result)
            System.out.println(s);

        sc.close();
    }
}
