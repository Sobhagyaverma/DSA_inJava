package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input Format:
- n (number of pairs)

Output Format:
- List of strings representing well-formed parentheses

Constraints:
1 <= n <= 8

Sample Input:
3
Sample Output:
["((()))","(()())","(())()","()(())","()()()"]
*/

public class GenerateParentheses {
    /**
     * Backtracking Approach:
     * We build the string character by character. We keep track of the number of
     * opening and closing parentheses used so far.
     * 1. If we have unused opening parentheses, we can add '('.
     * 2. If the number of closing parentheses is less than opening ones, we can add
     * ')'.
     * 
     * Choice: Add '(' or ')'.
     * Recursive Call: Call with updated counts.
     * Backtrack: Remove the last character.
     * 
     * Time Complexity: O(4^n / sqrt(n)) - Catalan number complexity.
     * Space Complexity: O(n) - Recursion depth.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Choice 1: add an open parenthesis
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Choice 2: add a close parenthesis
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of pairs n:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        GenerateParentheses obj = new GenerateParentheses();
        List<String> result = obj.generateParenthesis(n);

        System.out.println("Combinations:");
        for (String s : result)
            System.out.println(s);

        sc.close();
    }
}
