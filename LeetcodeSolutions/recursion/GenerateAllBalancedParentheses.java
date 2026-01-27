import java.util.*;

/**
 * Problem 20: Generate All Balanced Parentheses
 * (Similar to Problem 11)
 * 
 * Input Format:
 * An integer n representing number of pairs.
 * 
 * Output Format:
 * List of all valid balanced parentheses strings.
 * 
 * Approach:
 * Backtracking with state space search.
 * Pruning based on balance constraint: cannot add ')' if count of ')' >= count
 * of '('.
 */
public class GenerateAllBalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pairs (n): ");
        int n = sc.nextInt();

        List<String> res = new ArrayList<>();
        generate(n, 0, 0, "", res);

        System.out.println("Balanced Parentheses: " + res);
        sc.close();
    }

    private static void generate(int n, int open, int close, String current, List<String> res) {
        if (current.length() == 2 * n) {
            res.add(current);
            return;
        }

        if (open < n) {
            generate(n, open + 1, close, current + "(", res);
        }
        if (close < open) {
            generate(n, open, close + 1, current + ")", res);
        }
    }
}
