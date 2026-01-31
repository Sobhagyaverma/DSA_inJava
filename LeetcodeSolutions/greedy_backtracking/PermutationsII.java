package greedy_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given a collection of numbers, nums, that might contain duplicates, 
return all possible unique permutations in any order.

Input Format:
- n (size)
- n integers (may have duplicates)

Output Format:
- List of unique permutations

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10

Sample Input:
3
1 1 2
Sample Output:
[1, 1, 2], [1, 2, 1], [2, 1, 1]
*/

public class PermutationsII {
    /**
     * Backtracking Approach with Pruning:
     * To avoid duplicate permutations, we sort the array and use a 'used' array.
     * When processing an element, we skip it if it's a duplicate of the previous
     * element AND the previous element was NOT used in the current recursive path.
     * 
     * Choice: Pick nums[i].
     * Recursive Call: fill next position.
     * Backtrack: reset used[i] and remove element.
     * Pruning: if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
     * 
     * Time Complexity: O(n * n!).
     * Space Complexity: O(n).
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to bring duplicates together
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Pruning: skip used, or skip duplicates that haven't been picked yet
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            // Choice
            used[i] = true;
            current.add(nums[i]);

            // Recursive Call
            backtrack(result, current, nums, used);

            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
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

        PermutationsII obj = new PermutationsII();
        List<List<Integer>> res = obj.permuteUnique(nums);

        System.out.println("Unique permutations:");
        for (List<Integer> p : res)
            System.out.println(p);

        sc.close();
    }
}
