package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Find all valid combinations of k numbers that sum up to n such that the following conditions are met:
1. Only numbers 1 through 9 are used.
2. Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the 
same combination twice, and the combinations may be returned in any order.

Input Format:
- k (number of elements)
- n (target sum)

Output Format:
- List of combinations

Constraints:
2 <= k <= 9
1 <= n <= 60

Sample Input:
3
7
Sample Output:
[1, 2, 4]
*/

public class CombinationSumIII {
    /**
     * Backtracking Approach:
     * We try picking numbers from 1 to 9. We maintain the count of numbers picked
     * and the remaining sum.
     * 
     * Choice: Pick number 'i' from {start...9}.
     * Recursive Call: Call with target - i and count - 1, starting from i + 1.
     * Backtrack: Un-pick number 'i'.
     * Pruning: if current_count > k or current_sum > n, stop.
     * 
     * Time Complexity: O(9! / (9-k)!) - picking k out of 9.
     * Space Complexity: O(k) - Recursion depth.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int target, int start) {
        // Base case: check if we satisfied both constraints
        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            // Pruning: stop if number is already larger than needed target
            if (i > target)
                break;

            // Choice
            current.add(i);

            // Recursive Call: use i + 1 to avoid reuse
            backtrack(result, current, k, target - i, i + 1);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k (number of elements, 1-9):");
        if (!sc.hasNextInt())
            return;
        int k = sc.nextInt();

        System.out.println("Enter target sum n:");
        int n = sc.nextInt();

        CombinationSumIII obj = new CombinationSumIII();
        List<List<Integer>> res = obj.combinationSum3(k, n);

        System.out.println("Combinations:");
        for (List<Integer> c : res)
            System.out.println(c);

        sc.close();
    }
}
