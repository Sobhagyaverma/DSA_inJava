import java.util.Scanner;

/**
 * Problem 1: Factorial Trailing Zeroes
 * 
 * Input Format:
 * A single integer n.
 * 
 * Output Format:
 * Number of trailing zeroes in n!.
 * 
 * Approach:
 * A trailing zero is created by 10, which is 2 * 5. 
 * Since there are always more 2s than 5s in a factorial, we count the number of 5s.
 * We count factors of 5, 25, 125, etc.
 * Optimization: Recursive formula count = n/5 + trailingZeroes(n/5).
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number n: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println("Trailing zeroes in " + n + "! is: " + trailingZeroes(n));
        }
        sc.close();
    }

    public static int trailingZeroes(int n) {
        // Base case: if n is less than 5, no trailing zeroes from 5s
        if (n < 5) {
            return 0;
        }
        // Recursive step: n/5 counts multiples of 5, then we recurse for factors of higher powers of 5
        return (n / 5) + trailingZeroes(n / 5);
    }
}
