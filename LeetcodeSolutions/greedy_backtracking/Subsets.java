package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input Format:
- n (size of array)
- n unique integers

Output Format:
- List of all subsets

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All elements of nums are unique.

Sample Input:
3
1 2 3
Sample Output:
[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
*/

public class Subsets {
    /**
     * Backtracking Approach:
     * We explore the decision tree where at each step we choose whether to include
     * a specific element in the current subset.
     * 
     * Choice: Include nums[i] in the current subset.
     * Recursive Call: Move to process the next element (i + 1).
     * Backtrack: Remove nums[i] from the subset to explore the 'exclude' branch.
     * 
     * Time Complexity: O(n * 2^n) - There are 2^n subsets, and building each subset
     * takes O(n).
     * Space Complexity: O(n) - Path list and recursion depth.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Every state in the decision tree is a valid subset
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Choice: Include current element
            tempList.add(nums[i]);

            // Recursive Call: Explore with the choice
            backtrack(result, tempList, nums, i + 1);

            // Backtrack: Undo the choice
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
        System.out.println("Enter unique elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Subsets obj = new Subsets();
        List<List<Integer>> result = obj.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        sc.close();
    }
}
