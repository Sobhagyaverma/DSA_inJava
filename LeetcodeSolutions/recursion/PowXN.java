import java.util.Scanner;

/**
 * Problem 3: Pow(x, n)
 * 
 * Input Format:
 * A double x and an integer n.
 * 
 * Output Format:
 * x raised to the power n (x^n).
 * 
 * Approach:
 * Divide and Conquer (Binary Exponentiation).
 * x^n = (x^(n/2))^2 if n is even.
 * x^n = x * (x^(n/2))^2 if n is odd.
 * Optimization: Recursive depth O(log n).
 */
public class PowXN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();

        System.out.println(x + " ^ " + n + " = " + myPow(x, n));
        sc.close();
    }

    public static double myPow(double x, int n) {
        // Handle n = Integer.MIN_VALUE to avoid overflow when negating
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Recursive step: calculate half power
        double half = fastPow(x, n / 2);

        // Combine results
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
