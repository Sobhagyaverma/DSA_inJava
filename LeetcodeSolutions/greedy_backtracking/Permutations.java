package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order.

Input Format:
- n (size)
- n distinct integers

Output Format:
- List of permutations

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All integers of nums are unique.

Sample Input:
3
1 2 3
Sample Output:
[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]
*/

public class Permutations {
    /**
     * Backtracking Approach:
     * We build the permutation one position at a time. For each position,
     * we can pick any available element from the array.
     * 
     * Choice: Pick an element 'nums[i]' that hasn't been used yet.
     * Recursive Call: Fill the next position in the current permutation.
     * Backtrack: Un-mark the element as used and remove it from the path.
     * 
     * Time Complexity: O(n * n!) - n! permutations, O(n) to build each.
     * Space Complexity: O(n) - Used array and recursion stack.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // Base Case: Current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // Skip if already used

            // Choice: add element and mark it as 'used'
            used[i] = true;
            current.add(nums[i]);

            // Recursive Call: build the rest of the permutation
            backtrack(result, current, nums, used);

            // Backtrack: undo the choice
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of distinct elements:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter distinct elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Permutations obj = new Permutations();
        List<List<Integer>> result = obj.permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> p : result)
            System.out.println(p);

        sc.close();
    }
}
