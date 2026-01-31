package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Input Format:
- n (number of candidates)
- n distinct integers
- target (integer)

Output Format:
- List of combinations

Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

Sample Input:
3
2 3 6
7
Sample Output:
[2, 2, 3], [7]
*/

public class CombinationSum {
    /**
     * Backtracking Approach:
     * We explore a recursion tree where at each node we can choose to pick the
     * current candidate or move to the next candidate.
     * Since unlimited reuse is allowed, when we pick a candidate, we stay at the
     * same index in the next recursive call.
     * 
     * Choice: Include candidates[i].
     * Recursive Call: Call with target - candidates[i], starting from index i.
     * Backtrack: Remove candidates[i].
     * Pruning: if current_sum > target, stop exploring that branch.
     * 
     * Time Complexity: O(N^(T/M + 1)) where N is candidates, T is target, M is min
     * value in candidates.
     * Space Complexity: O(T/M) for the recursion stack.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        // Base case: success
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning
            if (candidates[i] <= target) {
                // Choice
                current.add(candidates[i]);

                // Recursive Call: we use 'i' again because reuse is allowed
                backtrack(result, current, candidates, target - candidates[i], i);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of candidates:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] candidates = new int[n];
        System.out.println("Enter distinct candidates:");
        for (int i = 0; i < n; i++)
            candidates[i] = sc.nextInt();

        System.out.println("Enter target:");
        int target = sc.nextInt();

        CombinationSum obj = new CombinationSum();
        List<List<Integer>> res = obj.combinationSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> c : res)
            System.out.println(c);

        sc.close();
    }
}
