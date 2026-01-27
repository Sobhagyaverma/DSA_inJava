import java.util.*;

/**
 * Problem 11: Generate Parentheses
 * 
 * Input Format:
 * An integer n representing number of pairs.
 * 
 * Output Format:
 * List of all valid balanced parentheses strings.
 * 
 * Approach:
 * Backtracking while keeping track of open and close counts to ensure balance.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);

        System.out.println("Balanced Parentheses: " + result);
        sc.close();
    }

    private static void backtrack(int max, int open, int close, StringBuilder current, List<String> result) {
        // Base case: current string length reaches 2*n
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Optimization/Pruning:
        // 1. Can add '(' if open < n
        if (open < max) {
            current.append('(');
            backtrack(max, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        // 2. Can add ')' if close < open
        if (close < open) {
            current.append(')');
            backtrack(max, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
