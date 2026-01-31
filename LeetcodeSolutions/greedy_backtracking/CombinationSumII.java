package greedy_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given a collection of candidate numbers candidates and a target number target, 
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Input Format:
- n (number of candidates)
- n integers (duplicates allowed)
- target (integer)

Output Format:
- List of unique combinations

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

Sample Input:
7
10 1 2 7 6 1 5
8
Sample Output:
[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]
*/

public class CombinationSumII {
    /**
     * Backtracking Approach with Pruning:
     * 1. Sort the input array to handle duplicates efficiently.
     * 2. When picking elements, skip duplicates at the same recursive depth.
     * 3. Move to the next index (i + 1) in the next recursive call (since reuse is
     * not allowed).
     * 
     * Choice: Include candidates[i].
     * Recursive Call: Call with target - candidates[i], starting from index i + 1.
     * Backtrack: Remove candidates[i].
     * Pruning: if (i > start && candidates[i] == candidates[i-1]) continue;
     * 
     * Time Complexity: O(2^n) - Worst case exponential.
     * Space Complexity: O(n) - Recursion depth.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: skip duplicates at current level
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            // Pruning: if current element is already bigger than remaining target
            if (candidates[i] > target)
                break;

            // Choice
            current.add(candidates[i]);

            // Recursive Call: next index (reuse not allowed)
            backtrack(result, current, candidates, target - candidates[i], i + 1);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of candidates:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] candidates = new int[n];
        System.out.println("Enter candidates (duplicates allowed):");
        for (int i = 0; i < n; i++)
            candidates[i] = sc.nextInt();

        System.out.println("Enter target:");
        int target = sc.nextInt();

        CombinationSumII obj = new CombinationSumII();
        List<List<Integer>> res = obj.combinationSum2(candidates, target);

        System.out.println("Unique combinations:");
        for (List<Integer> c : res)
            System.out.println(c);

        sc.close();
    }
}
