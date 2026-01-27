import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 2: Fibonacci Number
 * 
 * Input Format:
 * A single integer n.
 * 
 * Output Format:
 * The nth Fibonacci number.
 * 
 * Approach:
 * Classical recursion with Memoization to optimize from O(2^n) to O(n).
 */
public class FibonacciNumber {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            // Edge case: n < 0
            if (n < 0) {
                System.out.println("Fibonacci is not defined for negative numbers.");
            } else {
                System.out.println("Fibonacci(" + n + ") = " + fib(n));
            }
        }
        sc.close();
    }

    public static int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Memoization check
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive call
        int result = fib(n - 1) + fib(n - 2);
        
        // Save result in cache
        memo.put(n, result);
        return result;
    }
}
